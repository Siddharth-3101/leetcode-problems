class Trie {
    static class Node{
        Node[] next=new Node[26];
        boolean end;
    }
    public Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(cur.next[idx]==null){
                cur.next[idx]=new Node();
            }
            cur=cur.next[idx];
        }
        cur.end=true;  
    }
    
    public boolean search(String word) {
        Node cur=root;
        for(char ch:word.toCharArray()){
            int idx=ch-'a';
            if(cur.next[idx]==null){return false;}
            cur=cur.next[idx];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur=root;
        for(char ch:prefix.toCharArray()){
            int idx=ch-'a';
            if(cur.next[idx]==null){return false;}
            cur=cur.next[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */