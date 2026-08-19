class Solution {
    int[] parent;
    int find(int x){
        if(parent[x]==x){
            return x;
        }        
        return parent[x]=find(parent[x]);
    }
    public void union(int a,int b){
        int ra=find(a);
        int rb=find(b);
        if(ra!=rb){
            parent[rb]=ra;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(find(u)==find(v)){
                return edge;
            }
            union(u,v);
        }
        return new int[0];
    }
}