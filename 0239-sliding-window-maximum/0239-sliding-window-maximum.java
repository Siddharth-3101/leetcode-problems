class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[nums.length-k+1];
        int z=0;
        Deque<Integer> deque=new LinkedList<>();
        System.gc();
        for(int i=0;i<n;i++){
            while(!deque.isEmpty() &&deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                ans[z++]=nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}