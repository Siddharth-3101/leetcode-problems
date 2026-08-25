class Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            int x=i &(i-1);
            dp[i]=dp[x]+1;
        }
        return dp;
    }
}