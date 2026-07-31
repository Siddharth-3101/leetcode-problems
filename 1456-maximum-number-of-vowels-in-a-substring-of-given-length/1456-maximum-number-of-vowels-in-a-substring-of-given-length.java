class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        int maxcount=0;
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                count++;
            }
        }
        maxcount=count;
        int start=0;
        int end=k-1;
        while(end<s.length()-1){
            if(s.charAt(start)=='a'||s.charAt(start)=='e'||s.charAt(start)=='i'||s.charAt(start)=='o'||s.charAt(start)=='u'){
                count--;
            }
            start++;
            end++;
            if(s.charAt(end)=='a'||s.charAt(end)=='e'||s.charAt(end)=='i'||s.charAt(end)=='o'||s.charAt(end)=='u'){
                count++;
            }
            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}