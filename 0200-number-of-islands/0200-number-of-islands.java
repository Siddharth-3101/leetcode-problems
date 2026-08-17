class Solution {
    int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
    public void dfs(char[][] grid,boolean[][] visited,int row,int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||visited[row][col] ||grid[row][col] == '0'){
            return;
        }
        visited[row][col]=true;
        for(int[] dir:directions){
            int r=row+dir[0];
            int c=col+dir[1];
            dfs(grid,visited,r,c);
        }    
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    island++;
                dfs(grid,visited,i,j);
                }
            }
        }
        return island;
    }
}