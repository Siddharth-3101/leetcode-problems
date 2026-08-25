class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder st=new StringBuilder();
        for(char digit:num.toCharArray()){
            while(k>0 &&st.length()>0 && st.charAt(st.length()-1)>digit){
                k--;
                st.deleteCharAt(st.length()-1);
            }
            st.append(digit);
        }
        while(k>0){
            st.deleteCharAt(st.length()-1);
            k--;
        }
        int i=0;
        while(i<st.length() && st.charAt(i)=='0'){
            i++;
        }
        if(i==st.length()){
            return "0";
        }
        return st.toString().substring(i);
    }
}