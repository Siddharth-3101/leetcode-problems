class Solution {
    int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};
    public void dfs(char[][] grid,int row,int col,boolean[][] visited){
        int m=grid.length;
        int n=grid[0].length;
        if(row>=m||row<0 ||col>=n||col<0 ||visited[row][col]||grid[row][col]=='0'){
            return;
        }
        visited[row][col]=true;
        for(int[] dir:directions){
            int r=row+dir[0];
            int c=col+dir[1];
            dfs(grid,r,c,visited);
        }

    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
}