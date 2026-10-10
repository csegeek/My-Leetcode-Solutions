class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=0;
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        while(right<s.length()){
           if(map.containsKey(s.charAt(right))){
             map.put(s.charAt(right),map.get(s.charAt(right))+1);
           }
           else{
            map.put(s.charAt(right),1);
           }
           while(map.size()==3){
            count+=s.length()-right;

            if(map.get(s.charAt(left))==1){
                map.remove(s.charAt(left));
            }

            else{
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
            }
            left++;

           }

           right++;

        }
        return count;
    }
}