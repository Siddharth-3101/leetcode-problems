class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){return mid;}
            if(nums[low]<=nums[mid]){
                if(target<nums[mid] &&nums[low]<=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else{
                if(nums[mid]<=nums[high]){
                    if(target>nums[mid] && nums[high]>=target){
                        low=mid+1;
                    }
                    else{
                        high=mid-1;
                    }
                }
            }
        }
        return -1;
    }
}