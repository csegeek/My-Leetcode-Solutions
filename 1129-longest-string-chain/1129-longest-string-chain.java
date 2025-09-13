class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        return tabulation(words);
    }



    int tabulation(String [] words){
        int[] dp=new int[words.length+1];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=i-1;j++){
                if(checkPossible(words[i],words[j]) && 1+dp[j]>dp[i]){
                dp[i]=1+dp[j];
                } 
            }
            if(dp[i]>max){
             max=dp[i];
            }
        }
        return max;
     }

     boolean checkPossible(String s1, String s2){
        if(s1.length()!=s2.length()+1) return false;
        int first=0;
        int second=0;
        while (first < s1.length() && second < s2.length()) {
        if (s1.charAt(first) == s2.charAt(second)) {
            first++;
            second++;
        } else {
            first++;
        }
    }
        return second == s2.length(); // all of s2 matched in order
     }
}