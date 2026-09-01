class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
        }
        int sum=0;int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            if(sum==0){
                ans=Math.max(ans,i+1);
            }
            else if(map.containsKey(sum)){
                ans=Math.max(ans,i-map.get(sum));
            }
            else if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return ans;
    }
}