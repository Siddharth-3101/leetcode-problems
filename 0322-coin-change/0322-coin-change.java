class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int[][] ans = new int[amount + 1][m + 1];
        if(amount==0){
            return 0;
        }
        for (int i = 1; i <= amount; i++) {
            ans[i][0] = amount+10;
        }
        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= m; j++) {
                int rem = i - coins[j - 1];
                if (i >= coins[j - 1] && ans[rem][j]!=amount+10) {
                    ans[i][j] = Math.min(ans[i][j - 1], 1 + ans[rem][j]);
                } else {
                    ans[i][j] = ans[i][j - 1];
                }
            }
        }
        if(ans[amount][m]==amount+10){
            return -1;
        }
        return ans[amount][m];
    }
}