class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        //two pointer
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int left=i+1;
            int right=nums.length-1;
            if(i > 0 && nums[i] == nums[i-1])continue;
            while(left<right){
                int mid=nums[left]+nums[right];
                //use -num for getting the opposite sign number of mid which then which adds up to 0
                if(mid== -num){
                    ans.add(List.of(nums[i],nums[left],nums[right]));
                    //duplicate skipping
                    while(left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(mid< -num){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return ans;
    }
}