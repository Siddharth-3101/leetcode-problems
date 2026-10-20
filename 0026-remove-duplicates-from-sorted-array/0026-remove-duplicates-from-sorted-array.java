class Solution {
    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int num:nums){
            set.add(num);
        }
        int k=set.size();
        int j=0;
        for(int num:set){
            nums[j]=num;
            j++;
        }
        return k;
    }
}