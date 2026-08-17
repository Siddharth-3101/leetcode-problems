class Solution {
    Queue<int[]> queue=new LinkedList<>();
    int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(int[][] grid,boolean[][] visited,int row,int col){
        if(row<0 || row>=grid.length || col<0|| col>=grid[0].length || grid[row][col]==0 || visited[row][col]){
            return;
        }
        visited[row][col]=true;
        queue.offer(new int[]{row,col});
        for(int[] dir:direction){
            int r=row+dir[0];
            int c=col+dir[1];
            dfs(grid,visited,r,c);
        }
    }
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        outer:
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    dfs(grid,visited,i,j);
                    break outer;
                }
            }
        }
        int dist=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                int[] arr=queue.poll();
                for(int[] dir:direction){
                    int r=arr[0]+dir[0];
                    int c=arr[1]+dir[1];
                    if(r<0 || r>=grid.length ||c<0 || c>=grid[0].length){continue;}
                    if(grid[r][c]==0 && !visited[r][c]){
                        visited[r][c]=true;
                        queue.offer(new int[]{r,c});
                    }
                    if(grid[r][c]==1 && !visited[r][c]){
                        return dist;
                    }
                }
                size--;
            }
            dist++;
        }
        return dist;
    }
}