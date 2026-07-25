class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int len=0;
        int[] res=new int[n];
        for(int num:nums){
            int pos=Arrays.binarySearch(res,0,len,num);
            if(pos<0){
                pos=-(pos+1);
            }

            res[pos]=num;
            if(pos==len){
                len++;
            }
        }
        return len;
    }
}