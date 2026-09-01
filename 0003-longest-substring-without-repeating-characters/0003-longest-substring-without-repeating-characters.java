class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int n=s.length();
        int max=0;
        int left=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                left=Math.max(left,map.get(ch)+1);
            }
            max=Math.max(max,i-left+1);
            map.put(ch,i);
        }
        return max;
    }
}