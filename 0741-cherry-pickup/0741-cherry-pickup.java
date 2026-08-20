class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int[][] next = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = grid[0][0];
        for (int step = 1; step <= 2 * n - 2; step++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(next[i], Integer.MIN_VALUE);
            }
            for (int r1 = 0; r1 < n; r1++) {
                for (int r2 = 0; r2 < n; r2++) {
                    int c1 = step - r1;
                    int c2 = step - r2;
                    if (c1 < 0 || c2 < 0 || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
                        continue;
                    }
                    int cherries = 0;
                    if (r1 == r2 && c1 == c2) {
                        cherries = grid[r1][c1];
                    } else {
                        cherries = grid[r1][c1] + grid[r2][c2];
                    }
                    int best = Integer.MIN_VALUE;

                    if (r1 > 0 && r2 > 0)
                        best = Math.max(best, dp[r1 - 1][r2 - 1]);

                    if (r1 > 0)
                        best = Math.max(best, dp[r1 - 1][r2]);

                    if (r2 > 0)
                        best = Math.max(best, dp[r1][r2 - 1]);

                    best = Math.max(best, dp[r1][r2]);
                    if (best != Integer.MIN_VALUE) {
                        next[r1][r2] = cherries + best;
                    }
                }
            }
            int temp[][] = dp;
            dp = next;
            next = temp;
        }
        return Math.max(0,dp[n - 1][n - 1]);
    }
}