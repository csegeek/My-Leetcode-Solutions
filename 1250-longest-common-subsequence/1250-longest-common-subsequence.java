class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int [text1.length()][text2.length()];
         for(int i=0;i<text1.length();i++){
            Arrays.fill(dp[i],-1);
         }
        return recursion(text1.length()-1,text2.length()-1,text1,text2,dp);
    }

    int recursion(int i1,int i2,String text1,String text2,int [][] dp){
        //base case
        if(i1<0||i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(text1.charAt(i1)==text2.charAt(i2)){
          //  System.out.print("Matched-->"+text1.charAt(i1));
            return 1+recursion(i1-1,i2-1,text1,text2,dp);
        }
        else{
            return dp[i1][i2]=Math.max(recursion(i1-1,i2,text1,text2,dp),recursion(i1,i2-1,text1,text2,dp));
        }
    }
}