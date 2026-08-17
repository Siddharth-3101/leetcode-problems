class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return 0;
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size!=0){
                 String curr=queue.poll();
                char[] ch=curr.toCharArray();
                for(int i=0;i<ch.length;i++){
                    for(int j=0;j<26;j++){
                        char temp=ch[i];
                        ch[i]=(char)('a'+j);
                        String word=new String(ch);
                        if(word.equals(endWord)){return level+1;}
                        if(wordSet.contains(word) ){
                            queue.offer(word);
                            wordSet.remove(word);
                        }
                        ch[i]=temp;
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }
}