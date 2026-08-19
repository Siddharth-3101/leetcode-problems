class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int[][] dist=new int[n+1][2];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<=n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[1][0]=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] arr=queue.poll();
            int node=arr[0];
            int currentTime=arr[1];
            for(int neighbour:adj.get(node)){
                int nextTime=currentTime;
                if((nextTime/change)%2==1){
                    nextTime+=change-(nextTime%change);
                }
                int newTime=nextTime+time;
                if(newTime<dist[neighbour][0]){
                    dist[neighbour][1]=dist[neighbour][0];
                    dist[neighbour][0]=newTime;
                    queue.offer(new int[]{neighbour,newTime});
                }
                else if(dist[neighbour][0]<newTime && newTime<dist[neighbour][1]){
                    dist[neighbour][1]=newTime;
                    if(neighbour==n){
                        return newTime;
                    }
                    queue.offer(new int[]{neighbour,newTime});
                }
            }
        }
        return-1;
    }
}