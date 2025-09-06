class Solution {
    public int maxProfit(int[] prices) {
        int [][] dp=new int [prices.length][2];
        for(int[] dpi:dp){
            Arrays.fill(dpi,-1);
        }
        return recursion(0,1,prices,dp);
    }

    int recursion(int i,int buy,int [] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy] !=-1) return dp[i][buy];
        if(buy==1){
            return dp[i][buy]= Math.max(-prices[i]+recursion(i+1,0,prices,dp),recursion(i+1,1,prices,dp));
        }
        else{
            return dp[i][buy]= Math.max(prices[i]+recursion(i+2,1,prices,dp),recursion(i+1,0,prices,dp));
        }
    }
}