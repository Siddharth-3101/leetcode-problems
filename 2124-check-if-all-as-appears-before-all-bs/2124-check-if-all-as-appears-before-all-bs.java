class Solution {
    public boolean checkString(String s) {
        int n=s.length();
        boolean stat=false;
        for(int i=0;i<n;i++){
            if(stat && s.charAt(i)=='a'){
                return false;
            }
            else if(s.charAt(i)=='b'){
                stat=true;
            }
        }
        return true;
    }
}