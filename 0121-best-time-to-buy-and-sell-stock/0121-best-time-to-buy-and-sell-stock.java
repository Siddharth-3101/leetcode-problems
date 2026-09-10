class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int min=prices[0];
        int max=0;
        for(int i=0;i<n;i++){
            min=Math.min(min,prices[i]);
            profit=prices[i]-min;
            max=Math.max(max,profit);
        }
        return max;

    }
}