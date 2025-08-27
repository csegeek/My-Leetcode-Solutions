class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int dp[][]=new int [text1.length()+1][text2.length()+1];
        //  for(int i=0;i<=text1.length();i++){
        //     Arrays.fill(dp[i],-1);
        //  }
        // return recursion(text1.length(),text2.length(),text1,text2,dp);
        return tabulation(text1,text2);
    }

     /* Shifting of indexes has been done 
        to covert this recursive solution in tabulation. 
     */
    int recursion(int i1,int i2,String text1,String text2,int [][] dp){
       // System.out.println("Recursion called with ("+i1+","+i2+")");
        //base case
        if(i1==0||i2==0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(text1.charAt(i1-1)==text2.charAt(i2-1)){
         //  System.out.print("Matched-->"+text1.charAt(i1-1));
            return 1+recursion(i1-1,i2-1,text1,text2,dp);
        }
        else{
            return dp[i1][i2]=Math.max(recursion(i1-1,i2,text1,text2,dp),recursion(i1,i2-1,text1,text2,dp));
        }
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
    
    int n=text1.length();
    int m=text2.length();
    int len=dp[n][m];
    int i=n;
    int j=m;
    int index = len-1;
    String str="";
    for(int k=1; k<=len;k++){
        str +="$"; // dummy string
    }
    StringBuilder str2=new StringBuilder(str);
    while(i>0 && j>0){
        if(text1.charAt(i-1) == text2.charAt(j-1)){
            str2.setCharAt(index,text1.charAt(i-1) ); 
            index--;
            i--;
            j--;
        }
        else if(text1.charAt(i-1)>text2.charAt(j-1)){
            i--;
        }
        else j--;
    }
    System.out.println(str2);
    return len;
    }
}