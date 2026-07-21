class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] m=new int[n];
        if(n==0){return 0;}
        if(n==1){return nums[0];}
        m[0]=nums[0];
        m[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            m[i]=Math.max(m[i-1],(m[i-2]+nums[i]));
        }
        return m[n-1];
    }
}