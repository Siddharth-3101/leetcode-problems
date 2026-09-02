class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] directions={{0,-1},{0,1},{1,0},{-1,0}};
        int m=mat.length;
        int n=mat[0].length;
        int[][] dist=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],-1);
        }
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    dist[i][j]=0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            for(int[] dir:directions){
                int r=arr[0]+dir[0];
                int c=arr[1]+dir[1];
                if(r<0 ||c<0||r>=m||c>=n){continue;}
                if(dist[r][c]==-1){
                    dist[r][c]=dist[arr[0]][arr[1]]+1;
                    queue.offer(new int[]{r,c});
                }
            }
        }
        return dist;
    }
}