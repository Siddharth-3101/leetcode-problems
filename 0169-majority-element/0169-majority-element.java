class Solution {
    public int majorityElement(int[] nums) {
        int maxcount=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        List<Map.Entry<Integer,Integer>> ans=new ArrayList<>(map.entrySet());
        ans.sort((a,b)->b.getValue()-a.getValue());
        return ans.get(0).getKey();
        
    }
}