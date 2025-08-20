class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recursion(coins.length-1,amount,coins,dp);
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
}