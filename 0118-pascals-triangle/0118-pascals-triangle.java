class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row=new ArrayList<>();
            List<Integer> prev;
            if(i==0){
                prev=new ArrayList<>();
                prev.add(1);   
            }
            else{
            prev=ans.get(i-1);
            row.add(1);
            }
            for(int j=0;j<prev.size()-1;j++){
                row.add(prev.get(j)+prev.get(j+1));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}