class Solution {
    public int gcd(int a,int b){
        while(a!=0){
            int temp=b%a;
            b=a;
            a=temp;
        }
        return b;
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(target>x+y){
            return false;
        }
        return target% gcd(x,y)==0;
    }
}