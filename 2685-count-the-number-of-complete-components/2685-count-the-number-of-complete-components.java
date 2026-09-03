class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]){continue;}
            int edge=0;
            int vertices=0;
            Queue<Integer> queue=new LinkedList<>();
            queue.offer(i);
            visited[i]=true;
            while(!queue.isEmpty()){
                int node=queue.poll();
                vertices++;
                for(int next:adj.get(node)){
                    edge++;
                    if(!visited[next]){
                        visited[next]=true;
                        queue.offer(next);
                    }
                }
            }
            if((edge/2)==(vertices*(vertices-1)/2)){
                count++;
            }
        }
        return count;
    }
}