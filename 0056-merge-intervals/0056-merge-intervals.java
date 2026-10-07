class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int[] curr=intervals[0];
        List<int[]> ans=new ArrayList<>();
        for(int i=1;i<n;i++){
            int[] next=intervals[i];
            if(next[0]<=curr[1]){
                curr[1]=Math.max(curr[1],next[1]);
            }
            else{
                ans.add(curr);
                curr=next;                
            }
        }
        ans.add(curr);
        int[][] ans1=new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            ans1[i]=ans.get(i);
        }
        return ans1;
    }
}