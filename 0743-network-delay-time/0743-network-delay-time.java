class Solution {
    class Pair{
        int node;
        int distance;
        public Pair(int node,int distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] time:times){
            adj.get(time[0]).add(new int[]{time[1],time[2]});
        }
        TreeSet<Pair> set=new TreeSet<>((a,b)->{
            int nc=Integer.compare(a.distance,b.distance);
            if(nc!=0){
                return nc;
            }
            return Integer.compare(a.node,b.node);
        });
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        
        int node=k;
        set.add(new Pair(node,dist[k]));
        while(!set.isEmpty()){
            Pair current=set.pollFirst();
            int cdist=current.distance;
            int cnode=current.node;
            if(cdist!=dist[cnode]){
                continue;
            }
            for(int[] edge:adj.get(cnode)){
                int adjnode=edge[0];
                int adjdist=edge[1];
                if(cdist+adjdist <dist[adjnode]){
                    dist[adjnode]=cdist+adjdist;
                    set.add(new Pair(adjnode,cdist+adjdist));
                }
            }
        }
        int answer=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            answer=Math.max(answer,dist[i]);
        }
        return answer;
    }
}