class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack=new Stack<>();
        Stack<StringBuilder> stringStack=new Stack<>();
        int count=0;
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                count=count*10+(ch-'0');
            }
            else if(Character.isLetter(ch)){
                sb.append(ch);
            }
            else if(ch=='['){
                countStack.push(count);
                stringStack.push(sb);
                count=0;
                sb=new StringBuilder();
            }
            else if(ch==']'){
                int repeat=countStack.pop();
                StringBuilder prev=stringStack.pop();
                StringBuilder temp=new StringBuilder();
                for(int i=0;i<repeat;i++){
                    temp.append(sb);
                }
                prev.append(temp);
                sb=prev;
            }
        
        }
        return sb.toString();
    }
}