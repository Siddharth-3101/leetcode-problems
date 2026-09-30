class Solution {
    public int countGoodRotations(int[] nums) {
        int n=nums.length;
        int count=0;
        long total=0;
        for(int x:nums){
            total+=x;
        }
        long sum=0;
        for(int i=0;i<n/2;i++){
            sum+=nums[i];
        }
        for(int i=0;i<n;i++){
            if(sum>total-sum){
                count++;
            }
            sum-=nums[i];
            sum+=nums[(i+n/2)%n];
        }
        return count;
    }
}