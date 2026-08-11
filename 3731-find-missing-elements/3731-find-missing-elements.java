class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int max=0;
        int n=nums.length;
        for(int num:nums){
            set.add(num);
            if(max<num){
                max=num;
            }
        }
        int min=max;
        for(int num:nums){
            if(min>num){
                min=num;
            }
        }
        List<Integer> list=new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list;
        
    
    }
}