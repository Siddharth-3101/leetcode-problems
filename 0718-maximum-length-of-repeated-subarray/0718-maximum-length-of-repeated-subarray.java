class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[][] ans=new int[m+1][n+1];
        int len=0;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(nums1[i-1]==nums2[j-1]){
                    ans[i][j]=1+ans[i-1][j-1];
                    len=Math.max(len,ans[i][j]);
                }
                else{
                    ans[i][j]=0;
                }
            }
        }
        return len;
    }
}