class ProductOfNumbers {
    List<Integer> list=new ArrayList<>();
    public ProductOfNumbers() {
        list.add(1);
    }
    
    public void add(int num) {
        int n=list.size();
        if(num==0){
            list=new ArrayList<>();
            list.add(1);
        }
        else{
            list.add((list.get(n-1)*num));
        }
    }
    public int getProduct(int k) {
        int n=list.size();
        if(k>=n){
            return 0;
        }
        else{
            return list.get(n-1)/list.get(n-k-1);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */