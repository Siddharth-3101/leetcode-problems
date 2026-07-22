class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        boolean[][] ans=new boolean[m+1][n+1];
        ans[0][0]=true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                ans[0][i]=ans[0][i-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    ans[i][j]=(ans[i-1][j]||ans[i][j-1]);
                }
                else if(p.charAt(j-1)=='?'){
                    ans[i][j]=ans[i-1][j-1];
                }
                else if(s.charAt(i-1)==p.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }
            }
        }
        return ans[m][n];
    }
}