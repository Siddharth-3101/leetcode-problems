class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        int[] arr=new int[k];
        list.sort((a,b)->b.getValue()-a.getValue());
        for(int i=0;i<k;i++){
            arr[i]=list.get(i).getKey();
        }
        return arr;
    }
}