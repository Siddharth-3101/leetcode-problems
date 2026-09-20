class Solution {
    List<String> list=new ArrayList<>();
    public void backtrack(int open,int close,String current,int n){
        if(open == n && close == n){
            list.add(current);
            return;
            }
        if(open<n){
            backtrack(open+1,close,current+"(",n);
        }
        if(close<open){
            backtrack(open,close+1,current+")",n);
        }

    }
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,"",n);
        return list;
    }
}