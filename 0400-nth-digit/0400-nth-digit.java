class Solution {
    public int findNthDigit(int n) {
        long len=1;
        long count =9;
        long start=1;
        while(n>len*count){
            n-=len*count;
            len++;
            start*=10;
            count*=10;
        }
        long number=start+(n-1)/len;
        int digit=(int)((n-1)%len);
        String num=Long.toString(number);
        int ans=num.charAt(digit)-'0';
        return ans;
    }
}