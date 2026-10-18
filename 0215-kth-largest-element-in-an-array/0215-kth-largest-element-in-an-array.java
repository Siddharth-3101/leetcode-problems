class Solution {
    public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> ans=new PriorityQueue<>();
        for(int num : nums){
            ans.add(num);
            if(ans.size()>k){
                ans.poll();
            }
        }
        return ans.peek();
    }
}