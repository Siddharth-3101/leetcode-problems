class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] ans=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0){
                    ans[i][j]=i;
                }
                else if(i==0){
                    ans[i][j]=j;
                }
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    ans[i][j]=ans[i-1][j-1];
                }
                else{
                    ans[i][j]=1+Math.min(Math.min(ans[i-1][j],ans[i][j-1]),ans[i-1][j-1]);
                }
            }
        }
        return ans[m][n];
    }
}