class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] d=new int[n];
        d[0]=cost[0];
        d[1]=cost[1];
        for(int i=2;i<n;i++){
            d[i]=cost[i]+Math.min(d[i-1],d[i-2]);
        }
        return Math.min(d[n-1],d[n-2]);
    }
}