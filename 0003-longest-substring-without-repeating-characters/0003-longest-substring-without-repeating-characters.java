class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        Set<Character> set=new HashSet<>();
        int maxLength=0;
        int start=0;
        int end=start+1;
        set.add(s.charAt(start));
        while(start<end && end<s.length()){
            
                if(!set.contains(s.charAt(end))){
                    set.add(s.charAt(end));
                    end++;
                    
                }
                else{
                    maxLength=Math.max(maxLength,end-start);
                    start=start+1;
                    end=start+1;
                    set=new HashSet<>();
                    set.add(s.charAt(start));
                }
        }

        maxLength=Math.max(maxLength,end-start);
        return maxLength;
    }


}