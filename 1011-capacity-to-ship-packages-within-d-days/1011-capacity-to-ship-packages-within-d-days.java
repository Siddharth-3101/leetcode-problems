class Solution {
    public boolean check(int mid,int[] weights,int days){
        int w=0;
        int d=1;
        for(int num:weights){
            if(w+num<=mid){
                w+=num;
            }
            else{
                w=0+num;
                d++;
            }
        }
        if(d<=days){
            return true;
        }
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=1;
        int high=0;
        for(int num:weights){
            if(low<num){
                low=num;
            }
            high+=num;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(check(mid,weights,days)){
                high=mid-1;
                ans=mid;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}