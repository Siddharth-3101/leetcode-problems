class Solution {
    public int countPrimes(int n) {
        boolean[] isprime=new boolean[n+1];
        Arrays.fill(isprime,true);
        for(int i=2;i*i<n;i++){
            if(isprime[i]){
                for(int j=i*i ;j<n;j+=i){
                    isprime[j]=false;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(isprime[i]){
                count++;
            }
        }
        return count;
    }
}