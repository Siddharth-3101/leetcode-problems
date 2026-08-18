class Solution {
    class Pair {
        int cost;
        int node;
        int stops;

        public Pair(int cost, int node, int stops) {
            this.cost = cost;
            this.node = node;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            adj.get(from).add(new int[] { to, price });
        }
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            int cc = Integer.compare(a.cost, b.cost);
            if (cc != 0) {
                return cc;
            }
            int nc = Integer.compare(a.node, b.node);
            if (nc != 0) {
                return nc;
            }
            return Integer.compare(a.stops, b.stops);
        });
        int cost=0;
        int node=src;
        int stops=0;
        set.add(new Pair(cost,node,stops));
        while(!set.isEmpty()){
            Pair current=set.pollFirst();
            int ccost=current.cost;
            int cnode=current.node;
            int cstops=current.stops;
            if(cnode==dst){
                return ccost;
            }
            for(int[] edge:adj.get(cnode)){
                int adjnode=edge[0];
                int adjprice=edge[1];
                int newStops=cstops+1;
                if(newStops<=k || adjnode==dst){
                    set.add(new Pair(ccost+adjprice,adjnode,newStops));
                }
            }
        }
        return -1;
    }
}