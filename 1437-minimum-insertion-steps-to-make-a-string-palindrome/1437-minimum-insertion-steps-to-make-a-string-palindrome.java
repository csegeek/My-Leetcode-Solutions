class Solution {
    public int minInsertions(String s) {
        StringBuilder s1=new StringBuilder(s);
        s1.reverse();
        int lcp=tabulation(s,s1.toString());
        return s.length()-lcp;
        
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