class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int start=0;
        int end=p.length()-1;
        HashMap<Character,Integer> pmap=new HashMap<>();
        for(char str: p.toCharArray()){
            if(pmap.containsKey(str)){
                pmap.put(str,pmap.get(str)+1);
            }
            else{
                pmap.put(str,1);
            }
        }
        List<Integer> ans=new ArrayList<>();
        HashMap<Character,Integer> winmap=new HashMap<>();
        String win;
        if(p.length()>s.length()){
            return ans;
        }
        else{
            win=new String(s.substring(start,end+1));
        }
        
        for(char str:win.toCharArray()){
            if(winmap.containsKey(str)){
                winmap.put(str,winmap.get(str)+1);
            }
            else{
                winmap.put(str,1);
            }
        }
        
        if(pmap.equals(winmap)){
            ans.add(start);
        }
        while(end<s.length()-1){
            if(winmap.get(s.charAt(start))==1){
                winmap.remove(s.charAt(start));
            }
            else{
                winmap.put(s.charAt(start),winmap.get(s.charAt(start))-1);
            }
            start++;
            end++;
            if(winmap.containsKey(s.charAt(end))){
                winmap.put(s.charAt(end),winmap.get(s.charAt(end))+1);
            }
            else{
                winmap.put(s.charAt(end),1);
            }
            if(pmap.equals(winmap)){
            ans.add(start);}
        }   
        return ans;
    }
} 