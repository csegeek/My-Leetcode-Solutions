class Solution {
    public int minDistance(String word1, String word2) {
        int lcs=tabulation(word1,word2);
        return word1.length()-lcs+word2.length()-lcs;
    }

    int tabulation(String text1,String text2){
       int dp[][]=new int [text1.length()+1][text2.length()+1];
       for(int i1=1;i1<=text1.length();i1++){
        for(int i2=1;i2<=text2.length();i2++){
           if(text1.charAt(i1-1)==text2.charAt(i2-1)){
             dp[i1][i2]= 1+dp[i1-1][i2-1];
            } 
            else{
                dp[i1][i2]=Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        }
       }
    return dp[text1.length()][text2.length()];
    }
}