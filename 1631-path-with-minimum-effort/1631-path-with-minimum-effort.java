class Solution {
    class Pair{
        int effort;
        int row;
        int col;
        public Pair(int effort,int row,int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[][] direction={{-1,0},{1,0},{0,1},{0,-1}};
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        TreeSet<Pair> set=new TreeSet<>((a,b)->{
            int ec=Integer.compare(a.effort,b.effort);
            if(ec!=0){
                return ec;
            }
            int rc=Integer.compare(a.row,b.row);
            if(rc!=0){
                return rc;
            }
            return Integer.compare(a.col,b.col);
        });
        set.add(new Pair(0,0,0));
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=0;
        while(!set.isEmpty()){
            Pair current=set.pollFirst();
            int ceffort=current.effort;
            int crow=current.row;
            int ccol=current.col;
            if(crow==n-1 && ccol==m-1){
                return ceffort;
            }
            for(int[] dir: direction){
                int nr=crow+dir[0];
                int nc=ccol+dir[1];
                if(nr<0||nc<0|| nr>=n|| nc>=m){continue;}
                int eeffort=Math.abs(heights[crow][ccol]-heights[nr][nc]);
                int newEffort=Math.max(ceffort,eeffort);
                if(newEffort<dist[nr][nc]){
                    dist[nr][nc]=newEffort;
                    set.add(new Pair(newEffort,nr,nc));
                }
            }
        }
        return 0;
    }
}