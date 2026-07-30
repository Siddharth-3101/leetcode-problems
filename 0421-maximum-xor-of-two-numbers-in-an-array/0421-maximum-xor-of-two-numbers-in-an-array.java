class Solution {
    class Node{
        Node[] next=new Node[2];
    }
    Node root=new Node();
    public void insert(int num){
        Node cur=root;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            if(cur.next[bit]==null){
                cur.next[bit]=new Node();
            }
            cur=cur.next[bit];
        }
    }
    public int getMax(int num){
        Node cur=root;
        int ans=0;
        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;
            int opposite=1-bit;
            if(cur.next[opposite]!=null){
                ans |= (1<<i);
                cur=cur.next[opposite];
            }
            else{
                cur=cur.next[bit];
            }
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        for(int num:nums){
            insert(num);
        }
        int ans=0;
        for(int num:nums){
            ans=Math.max(ans,getMax(num));
        }
        return ans;
    }
}