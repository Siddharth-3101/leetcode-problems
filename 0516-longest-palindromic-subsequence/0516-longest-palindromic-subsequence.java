class Solution {
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        String s1=new StringBuilder(s).reverse().toString();
        int n=s1.length();
        int[][] ans=new int[m+1][n+1];
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==0||j==0){
                    ans[i][j]=0;
                    continue;
                }
                if(s.charAt(i-1)==s1.charAt(j-1)){
                    ans[i][j]=1+ans[i-1][j-1];
                }
                else{
                    ans[i][j]=Math.max(ans[i-1][j],ans[i][j-1]);
                }
            }
        }
        return ans[m][n];
    }
}