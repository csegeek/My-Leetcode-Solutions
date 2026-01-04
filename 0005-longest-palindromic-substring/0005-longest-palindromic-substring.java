class Solution {
    public String longestPalindrome(String s) {
        int start=0;
        int end=0;

        for(int i=0;i<s.length();i++){
            int oddLength=expandLength(s,i,i);
            int evenLength=expandLength(s,i,i+1);
            int maxLength=Math.max(oddLength,evenLength);
            if(maxLength>end-start){
                start=i-(maxLength-1)/2;
                end=i+maxLength/2;
            }

        }
      return s.substring(start,end+1);
    }

    private int expandLength(String s ,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}