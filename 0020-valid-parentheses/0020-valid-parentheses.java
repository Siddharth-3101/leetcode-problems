class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char ch,ch1;
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch=='{'||ch=='['||ch=='('){
            stack.push(ch);}
            else{
                if(stack.isEmpty()){
                    return false;
                }
            ch1=stack.peek();
            if((ch1=='{'&& ch=='}')||(ch1=='['&& ch==']')||(ch1=='('&& ch==')')){
                    stack.pop();
            }
            
            else{
                return false;
            }}
        }
        return stack.isEmpty();
    }
    
}