class Solution {
    public int kthFactor(int n, int k) {
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                k--;
                if(k==0){
                    return i;
                }
            }
        }
        for(int i=(int) Math.sqrt(n);i>=1;i--){
            if(n%i==0){
                int pair=n/i;
                if(pair!=i){
                    k--;
                    if(k==0){
                    return pair;
                    }
                }
            }
        }
        return -1;
    }
}