class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int arrows=1;
        int arrpos=points[0][1];
        for(int i=0;i<points.length;i++){
            if(arrpos<points[i][0]){
                arrows++;
                arrpos=points[i][1];
            }
        }
        return arrows;
    }
}