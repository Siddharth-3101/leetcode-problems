class Solution {
    public int LowerBound(List<Var> jobs,int len,int num){
        int low=0;
        int high=len-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(jobs.get(mid).end<=num){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return high;
    }
    class Var{
        int start;
        int end;
        int profit;
        public Var(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=profit.length;
        List<Var> jobs=new ArrayList<>();
        for(int i=0;i<n;i++){
            jobs.add(new Var(startTime[i],endTime[i],profit[i]));
        }
        jobs.sort((a,b)->Integer.compare(a.end,b.end));
        int[] dp=new int[n];
        dp[0]=jobs.get(0).profit;
        for(int i=1;i<n;i++){
            int j=LowerBound(jobs,n,jobs.get(i).start);
            int use=0;
            if(j==-1){use=0;}
            else{
                use=dp[j];
            }
            int skip=dp[i-1];
            int take=jobs.get(i).profit+use;
            dp[i]=Math.max(skip,take);
        }
        return dp[n-1];

    }
}