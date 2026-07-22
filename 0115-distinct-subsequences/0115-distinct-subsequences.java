class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[][] ans=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            ans[i][0]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1]+ans[i-1][j];
                }
                else{
                    ans[i][j]=ans[i-1][j];
                }
            }
        }
        return ans[m][n];
    }
}