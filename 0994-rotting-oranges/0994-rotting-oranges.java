class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(fresh==0){return 0;}
        int minutes=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                int[] arr=queue.poll();
                for(int[] dir:direction){
                    int r=arr[0]+dir[0];
                    int c=arr[1]+dir[1];
                    if(r<0||c<0||r>=m||c>=n){continue;}
                    if(grid[r][c]==1){
                        grid[r][c]=2;
                        queue.offer(new int[]{r,c});
                        fresh--;
                    }
                }
                size--;
            }
            minutes++;
        }
        if(fresh>0){return -1;}
        return minutes;
    }
}