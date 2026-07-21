class Solution {
    public int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int gcdOfOddEvenSums(int n) {
        int sumE=2;
        int sumO=1;
        for(int i=3;i<=n*2;i++){
            if(i%2==0){
                sumE+=i;
            }
            else{
                sumO+=i;
            }
        }
        return gcd(sumE,sumO);

    }
}