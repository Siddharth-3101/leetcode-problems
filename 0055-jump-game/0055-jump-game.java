class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        int farthest=0;
        for(int i=0;i<n;i++){
            if(farthest<i){
                return false;
            }
            else{
                farthest=Math.max(farthest,nums[i]+i);
            }
            if(farthest>=n-1){
                return true;
            }
        }
        return false;
        
    }
}