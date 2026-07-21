class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] ans=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==0||j==0){
                    ans[i][j]=0;
                    continue;
                }
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    ans[i][j]=1+ans[i-1][j-1];
                }
                else{
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        int a=(m-ans[m][n])+(n-ans[m][n]);
        return a;
    }
}