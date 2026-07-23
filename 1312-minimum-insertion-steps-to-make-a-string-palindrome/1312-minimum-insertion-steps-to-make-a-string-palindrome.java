class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        String rev=new StringBuilder(s).reverse().toString();
        int[][] ans=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==rev.charAt(j-1)){
                    ans[i][j]=1+ans[i-1][j-1];
                }
                else{
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        return n-ans[n][n];
    }
}