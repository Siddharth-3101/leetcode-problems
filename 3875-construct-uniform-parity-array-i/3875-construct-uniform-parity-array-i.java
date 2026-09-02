class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length;
        int even=0;int odd=0;
        for(int i=0;i<n;i++){
            if(nums1[i]%2==0){
                even++;
            }
            else{
                odd++;
            }
        }
        if(even==n||odd==n){return true;}
        return true;
    }
}