class Solution {
    public void dfs(String cur,String beginWord, Map<String,List<String>> parent,List<String> path,List<List<String>> result){
        path.add(cur);
        if(cur.equals(beginWord)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
        }
        else{
            List<String> that=parent.get(cur);
            for(String check:that){
                dfs(check,beginWord,parent,path,result);
            }
        }
        path.remove(path.size()-1);        
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)){
            return new ArrayList<>();
        }
        wordSet.remove(beginWord);
        Map<String,List<String>> parent=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size=queue.size();
            Set<String> visited=new HashSet<>();
            boolean found=false;
            while(size!=0){
                String curr=queue.poll();
                char[] ch=curr.toCharArray();
                for(int i=0;i<ch.length;i++){
                    for(int j=0;j<26;j++){
                        char temp=ch[i];
                        ch[i]=(char) ('a'+j);
                        String word=new String(ch);
                        
                        if(wordSet.contains(word) ){
                            if(!visited.contains(word)){
                                queue.offer(word);
                                visited.add(word);
                                List<String> list=new ArrayList<>();
                                parent.put(word,new ArrayList<>());
                            }
                            parent.get(word).add(curr);
                            if(word.equals(endWord)){found=true;}
                        }
                        else if(visited.contains(word)){
                            parent.get(word).add(curr);
                        }
                        
                        ch[i]=temp;
                    }
                }
                size--;
            }
            wordSet.removeAll(visited);
            if(found){break;}
        }
        if (!parent.containsKey(endWord)) {
            return new ArrayList<>();
        }
        List<List<String>> result=new ArrayList<>();
        List<String> path=new ArrayList<>();
        dfs(endWord,beginWord,parent,path,result);
        return result;

    }
}