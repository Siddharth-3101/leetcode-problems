class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] ans = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            ans[i][0] = ans[i - 1][0] + (int) s1.charAt(i - 1);
        }
        for (int j = 1; j <= n; j++) {
            ans[0][j] = ans[0][j - 1] + (int) s2.charAt(j - 1);
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }
                else{
                    int a=ans[i-1][j]+(int) s1.charAt(i-1);
                    int b=ans[i][j-1]+(int) s2.charAt(j-1);
                    ans[i][j]=Math.min(a,b);
                }
            }
        }
        return ans[m][n];
    }
}