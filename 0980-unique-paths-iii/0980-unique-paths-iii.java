class Solution {
    int m;
    int n;
    int endId;
    int[][] grid;
    int finalMask;
    int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
    Map<Long,Integer> map=new HashMap<>();
    public int uniquePathsIII(int[][] grid) {
        this.grid=grid;
        m=grid.length;
        n=grid[0].length;
        int startId=0;
        finalMask=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=-1){
                    int id=i*n+j;
                    finalMask|=(1<<id);
                }
                if(grid[i][j]==1){
                    startId=i*n+j;
                }
                if(grid[i][j]==2){
                    endId=i*n+j;
                }
            }
        }
        int startMask=1<<startId;
        return dfs(startId,startMask);
    }
    public int dfs(int cellId,int mask){
        if(cellId==endId){
            if(mask==finalMask){
                return 1;
            }
            else{
                return 0;
            }
        }
        long key=((long)cellId<<32) |mask;
        int r=cellId/n;
        int c=cellId%n;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int count=0;
        for(int[] dir:direction){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nc<0||nr<0||nc>=n||nr>=m){
                continue;
            }
            if(grid[nr][nc]==-1){continue;}
            int nextId=nr*n+nc;
            if((mask & (1<<nextId))!=0){
                continue;
            }
            count+=dfs(nextId,mask|(1<<nextId));
        }
        map.put(key,count);
        return count;
    }
}