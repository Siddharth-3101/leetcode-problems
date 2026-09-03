class Solution {
    int[][] direction={{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char[][] grid,boolean[][] visited,int row,int col){
        if(row<0||col<0||row>=grid.length||col>=grid[0].length||grid[row][col]=='0'||visited[row][col]){return;}
        visited[row][col]=true;
        for(int[] dir:direction){
            int r=row+dir[0];
            int c=col+dir[1];
            dfs(grid,visited,r,c);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int island=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid,visited,i,j);
                    island++;
                }
            }
        }
        return island;
    }
}