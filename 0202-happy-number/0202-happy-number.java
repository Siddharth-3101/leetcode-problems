class Solution {
    public int ans(int n){
        String w=Integer.toString(n);
        char[] ch=w.toCharArray();
        int sum=0;
        for(int i=0;i<ch.length;i++){
            int num= ch[i]-'0';
            sum+=num*num;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n=ans(n);
        }
        return true;
    }
}