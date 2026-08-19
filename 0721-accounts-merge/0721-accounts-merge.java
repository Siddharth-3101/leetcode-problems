class Solution {
    HashMap<String,Integer> map;
    int[] parent;
    public int find(int x){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        map=new HashMap<>();
        int n=accounts.size();
        parent=new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            List<String> account=accounts.get(i);
            int size=account.size();
            String acc=account.get(0);
            for(int j=1;j<size;j++){
                if(!map.containsKey(account.get(j))){
                    map.put(account.get(j),i);
                }
                else{
                    union(i,map.get(account.get(j)));
                }
            }
        }
        List<Set<String>> groups=new ArrayList<>();
        for(int i=0;i<n;i++){
            groups.add(new HashSet<>());
        } 
        for(int i=0;i<n;i++){
            int root=find(i);
            for(int j=1;j<accounts.get(i).size();j++){
                groups.get(root).add(accounts.get(i).get(j));
            }
        }
        List<List<String>> result=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (groups.get(i).isEmpty()) {
                continue;
            }
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(i).get(0));
            List<String> emails = new ArrayList<>(groups.get(i));
            Collections.sort(emails);
            merged.addAll(emails);
            result.add(merged);
        }

        return result;
    }
}