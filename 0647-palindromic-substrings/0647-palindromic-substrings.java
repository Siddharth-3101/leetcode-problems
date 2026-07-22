class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        int[][] ans=new int[n][n];
        for(int diff=0;diff<s.length();diff++){
           int i=0;
           int j=diff;
           while(i<n && j<n){
            if(i==j){
                ans[i][j]=1;
            }
            else if(diff==1){
                if(s.charAt(i)==s.charAt(j)){
                    ans[i][j]=2;
                }
            }
            else{
                if(s.charAt(i)==s.charAt(j) && ans[i+1][j-1]>0){
                    ans[i][j]=2+ans[i+1][j-1];
                }
            }
            if(ans[i][j]!=0){
                count++;
            } 
            i++;
            j++;
           }
                      
        }
        return count;
    }
}