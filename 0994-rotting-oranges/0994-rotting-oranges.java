class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int minutes=-1;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                int[] arr=queue.poll();
                for(int[] dir:directions){
                    int r=arr[0]+dir[0];
                    int c=arr[1]+dir[1];
                    if(r<0 || r>=grid.length ||c<0 || c>=grid[0].length){continue;}
                    if(grid[r][c]==1){
                        grid[r][c]=2;
                        fresh--;
                        queue.offer(new int[]{r,c});
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