class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });
        List<int[]> ans=new ArrayList<>();
        for(int[] person:people){
            int k=person[1];
            ans.add(k,person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}