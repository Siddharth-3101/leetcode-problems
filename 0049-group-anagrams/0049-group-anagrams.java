class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans=new HashMap<>();
        for(String str : strs){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String key = new String(arr);
        if(!ans.containsKey(key)){
            ArrayList<String> list=new ArrayList<>();
            list.add(str);
            ans.put(key, list);
        }
        else{
            ans.get(key).add(str);
        }

        }
        return new ArrayList<>(ans.values());
    }
}