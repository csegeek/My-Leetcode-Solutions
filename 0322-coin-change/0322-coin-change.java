class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length==0) return -1;
        if(coins.length==1 && amount%coins[0] !=0 ) return -1;
       // Integer[][] dp=new Integer[coins.length][amount+1];
        int ans=tabulation(coins,amount);
      return ans!=1e9 ? ans : -1;  
    }

    int recursion(int i,int[] coins,int amount,Integer[][] dp){
      if(i<=0){
        if(amount%coins[i]==0){
            return amount/coins[i];
        }
        else{
            return (int) 1e9;
        }
      }
      if(amount==0) return 0;
      if(dp[i][amount]!=null) return dp[i][amount];
      int pick=(int) +1e9;
      if(coins[i]<=amount){
        pick=1+recursion(i,coins,amount-coins[i],dp);
      }
      int notPick=0+recursion(i-1,coins,amount,dp);
      return dp[i][amount]= Math.min(pick,notPick); 
    }

    int tabulation(int [] coins,int amount){
      Integer[][] dp=new Integer[coins.length][amount+1];
      for(int a=0;a<=amount;a++){
        if(a%coins[0]==0){
            dp[0][a]=a/coins[0];
        }
        else{
            dp[0][a]=(int) 1e9;
        }
      }
      for(int i=1;i<coins.length;i++){
        for(int a=0;a<=amount;a++){
            int pick=(int) +1e9;
      if(coins[i]<=a){
        pick=1+dp[i][a-coins[i]];
      }
      int notPick=0+dp[i-1][a];
       dp[i][a]= Math.min(pick,notPick); 
        }
      }
      return dp[coins.length-1][amount];

    }
}