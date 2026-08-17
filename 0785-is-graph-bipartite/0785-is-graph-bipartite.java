class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(color[i]==0){
                color[i]=-1;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int curr=queue.poll();
                    for(int num:graph[curr]){
                        if(color[num]==0){
                            if(color[curr]==1){
                                color[num]=-1;
                            }
                            else{
                                color[num]=1;
                            }
                            queue.offer(num);
                        }
                        if(color[num]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}