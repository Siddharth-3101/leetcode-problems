class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int target=0;
        if(sum%2==0){
            target=sum/2;
        }
        else{
            return false;
        }
        boolean[][] ans=new boolean[target+1][n+1];
        ans[0][0]=true;
        for(int j=0;j<=n;j++){
            ans[0][j]=true;
        }
        for(int i=0;i<=target;i++){
            for(int j=1;j<=n;j++){
                if(i>=nums[j-1]){
                    int rem=i-nums[j-1];
                    ans[i][j]=ans[i][j-1]||ans[rem][j-1];
                }
                else{
                    ans[i][j]=ans[i][j-1];
                }
            }
        }
        return ans[target][n];
    }
}