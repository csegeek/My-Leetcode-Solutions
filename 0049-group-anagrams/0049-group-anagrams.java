class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      
      HashMap<HashMap<Character,Integer>,ArrayList<String>> bmap=new HashMap<>(); 
      List<List<String>> response=new ArrayList<>();
        for(String str:strs){
            HashMap<Character,Integer> fmap=new HashMap<>();
            for(char c:str.toCharArray()){
                if(fmap.containsKey(c)){
                    fmap.put(c,fmap.get(c)+1);
                }
                else{
                    fmap.put(c,1);
                }
            }
            if(bmap.containsKey(fmap)){
                ArrayList<String> temp=bmap.get(fmap);
                temp.add(str);
                bmap.put(fmap,temp);
            }
            else{
                ArrayList<String> temp =new ArrayList<>();
                temp.add(str);
                bmap.put(fmap,temp);
            }
        }
        for(HashMap<Character,Integer> key:bmap.keySet()){
            response.add(bmap.get(key));
        }
        return response;
    }
}