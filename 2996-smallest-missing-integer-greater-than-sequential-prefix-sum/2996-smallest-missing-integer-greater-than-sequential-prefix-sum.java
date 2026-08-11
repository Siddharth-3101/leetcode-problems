class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        int rem=0;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                rem=i;
            }
            else{
                break;
            }
        }
        int ans=0;
        for(int i=0;i<=rem;i++){
            ans+=nums[i];
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=rem;i<n;i++){
            set.add(nums[i]);
        }
        while(set.contains(ans)){
            ans++;
        }
        return ans;
    }
}