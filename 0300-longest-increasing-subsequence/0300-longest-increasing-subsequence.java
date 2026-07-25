class Solution {
    public int LowerBound(int[] res,int len,int num){
        int low=0;
        int high=len;
        while(low<high){
            int mid=low+(high-low)/2;
            if(res[mid]>=num){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int len=0;
        int[] res=new int[n];
        for(int num:nums){
            int pos=LowerBound(res,len,num);
            res[pos]=num;
            if(pos==len){
                len++;
            }
        }
        return len;
    }
}