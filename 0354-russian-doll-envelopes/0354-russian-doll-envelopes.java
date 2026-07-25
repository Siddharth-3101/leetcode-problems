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
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int n=envelopes.length;
        int len=0;
        int[] res=new int[n];
        for(int[] envelope:envelopes){
            int val=envelope[1];
            int pos=LowerBound(res,len,val);
            res[pos]=val;
            if(pos==len){
                len++;
            }
        }
        return len;
    }
}