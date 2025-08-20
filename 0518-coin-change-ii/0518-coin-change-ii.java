class Solution {
    public int change(int amount, int[] coins) {
        // int[][] dp=new int[coins.length][amount+1];
        // for(int i=0;i<coins.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return recursion(coins.length-1,amount,coins,dp);
        return tabulation(amount,coins);
    }
    int recursion(int i,int t,int [] coins,int[][] dp){
        if(t==0) return 1;
        if(i==0){
            if(t%coins[i]==0) return 1;
            else return 0;
        }
        if(dp[i][t]!=-1) return dp[i][t];
        int pick=0;
        if(t>=coins[i]){
            pick=recursion(i,t-coins[i],coins,dp);
        }
        int notPick=recursion(i-1,t,coins,dp);
        return dp[i][t]= pick+notPick;
    }
    int tabulation(int amount,int[] coins){
     int[][] dp=new int[coins.length][amount+1];
     for(int i=0;i<coins.length;i++){
        dp[i][0]=1;
     }
     for(int i=0;i<=amount;i++){
        if(i%coins[0]==0)
        dp[0][i]=1;
     }
     for(int i=1;i<coins.length;i++){
        for(int t=0;t<=amount;t++){
            int pick=0;
        if(t>=coins[i]){
            pick=dp[i][t-coins[i]];
        }
        int notPick=dp[i-1][t];
         dp[i][t]= pick+notPick;
        }
     }
   return dp[coins.length-1][amount];

    }
}