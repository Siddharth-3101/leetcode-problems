class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int currgas=0;
        int netgas=0;
        int pos=0;
        for(int i=0;i<n;i++){
            int diff=gas[i]-cost[i];
            netgas+=diff;
            currgas+=diff;
            if(currgas<0){
                pos=i+1;
                currgas=0;
            }
        }
        if(netgas>=0){return pos;}
        return -1;
    }
}