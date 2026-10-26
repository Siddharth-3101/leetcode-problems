class Solution {
    int[][] direction={{1,0},{0,1},{-1,0},{0,-1}};
    long dfs(int[][] grid,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        if(row<0||row>=m||col<0||col>=n||grid[row][col]==0){
            return 0;
        }
        long sum=grid[row][col];
        grid[row][col]=0;
        for(int dir[]:direction){
            int r=row+dir[0];
            int c=col+dir[1];
            sum+=dfs(grid,r,c);
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if( grid[i][j]>0){
                    long sum=dfs(grid,i,j);
                    if(sum%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}