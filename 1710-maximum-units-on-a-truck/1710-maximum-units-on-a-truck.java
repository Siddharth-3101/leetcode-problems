class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int i=0;
        int sum=0;
        int curr=0;
        while(i<boxTypes.length){
            int boxes=boxTypes[i][0];
            int units=boxTypes[i][1];
            if(boxes<=truckSize){
                sum+=(boxes*units);
                truckSize-=boxes;//here we subtract current boxes from tucksize
            }
            else{
                sum+=(truckSize*units);//here for the last remaining boxes we calucate sum using the current units and remaining boxes
                truckSize=0;
                break;
            }
            i++;
        }
        return sum;

    }
}