class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] ans=new String[n];
        int[] cl=score.clone();
        Arrays.sort(cl);
        Map<Integer,String> rank=new HashMap<>();
        for(int i=0;i<n;i++){
            int rank1=n-i;
            if(rank1==1){
                rank.put(cl[i],"Gold Medal");
            }
            else if(rank1==2){
                rank.put(cl[i],"Silver Medal");
            }
            else if(rank1==3){
                rank.put(cl[i],"Bronze Medal");
            }
            else{
                rank.put(cl[i],String.valueOf(rank1));
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=rank.get(score[i]);
        }
        return ans;
    }
}