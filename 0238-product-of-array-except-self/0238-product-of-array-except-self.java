class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] right=new int[n]; 
        int[] left=new int[n];
        int[] ans=new int[n];
        left[0]=1;
        right[n-1]=1;
        for(int i=1;i<=n-1;i++){
            left[i]=left[i-1]*nums[i-1];

        }
        for(int j=n-2;j>=0;j--){
            right[j]=nums[j+1]*right[j+1];
        }
        for(int k=0;k<n;k++){
            ans[k]=right[k]*left[k];
        }
        return ans;
    }
}