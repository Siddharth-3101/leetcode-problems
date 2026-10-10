class NumArray {
    private int[] tree;
    private int[] nums;
    private int n;
    public NumArray(int[] nums) {
        this.nums=nums;
        this.n=nums.length;
        this.tree=new int[n+1];
        for(int i=0;i<n;i++){
            tree[i+1]=nums[i];
        }
        for(int i=0;i<n;i++){
            int parent=i+(i&-i);
            if(parent<=n){
                tree[parent]+=tree[i];
            }
        }
    }
    
    public void update(int index, int val) {
        int del=val-nums[index];
        nums[index]=val;
        int i=index+1;
        while(i<=n){
            tree[i]+=del;
            i=i+(i&-i);
        }
    }
    
    public int prefixSum(int i){
        int sum=0;
        while(i>0){
            sum+=tree[i];
            i-=i&-i;
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        return prefixSum(right+1)-prefixSum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */