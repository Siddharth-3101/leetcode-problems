class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int maxsum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        maxsum=sum;
        int start=0;
        int end=k-1;
        while(end<nums.length-1){
            sum-=nums[start];
            start++;
            end++;
            sum+=nums[end];
            maxsum=Math.max(maxsum,sum);
        }
        double avg=(double) maxsum/k;
        return avg;
    }
}