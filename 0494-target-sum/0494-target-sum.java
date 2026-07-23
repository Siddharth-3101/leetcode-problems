class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(Math.abs(target)>sum){
            return 0;
        }
        if(!((target+sum)%2==0)){
            return 0;
        }
        int target1=(target+sum)/2;
        int[][] ans=new int[target1+1][n+1];
        ans[0][0]=1;
        for(int j=0;j<=n;j++){
            ans[0][j]=1;
        }
        for(int i=0;i<=target1;i++){
            for(int j=1;j<=n;j++){
                if(i>=nums[j-1]){
                    int rem=i-nums[j-1];
                    ans[i][j]=ans[i][j-1]+ans[rem][j-1];
                }
                else{
                    ans[i][j]=ans[i][j-1];
                }
            }
        }
        return ans[target1][n];
    }
}