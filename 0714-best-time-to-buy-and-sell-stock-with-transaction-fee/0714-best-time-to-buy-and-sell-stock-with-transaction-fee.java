class Solution {
    public int maxProfit(int[] prices, int fee) {
      int [] [] dp=new int[prices.length][2];
      for(int[] dpi:dp){
        Arrays.fill(dpi,-1);
      }
      return recursion(0,0,prices,fee,dp);  
    }
    int recursion(int i,int buy,int[] prices,int fee,int[][] dp){
        if(i==prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        if(buy==0){
            return dp[i][buy]= Math.max(-prices[i]+recursion(i+1,1,prices,fee,dp),recursion(i+1,0,prices,fee,dp));
        }
        else{
            return  dp[i][buy]=Math.max(prices[i]-fee+recursion(i+1,0,prices,fee,dp),recursion(i+1,1,prices,fee,dp));
        }
    }
}