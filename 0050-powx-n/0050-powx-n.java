class Solution {
    public double myPow(double x, int n) {
        long n1=(long) n;
        if(n1<0){
            return 1/solve(x,Math.abs(n1));
        }
        return solve(x,n1);
    }
    public double solve(double x,long n){
        if(n==0){return 1;}
        if(n==1){return x;}
        
        double half=solve(x,n/2);
        if(n%2==0){
            return half*half;
        }
        else{
            return x*half*half;
        }
    }
}