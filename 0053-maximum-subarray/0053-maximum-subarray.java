class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=nums[0];
        int sum=nums[0];
        for (int i=1;i<=nums.length-1;i++){
            if(nums[i]>(nums[i]+currentSum)){
                currentSum=nums[i];
            }
            else{
                currentSum=nums[i]+currentSum;
            }
             if(sum<currentSum){
                sum=currentSum;
            }
        }
        return sum;
    }
}