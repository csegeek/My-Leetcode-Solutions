class Solution {
    public int maxProfit(int k, int[] prices) {
    //     int [][][] dp=new int [prices.length][2][k+1];
    //     for(int[][] dpi:dp){
    //         for(int[] dpj:dpi){
    //             Arrays.fill(dpj,-1);
    //         }
    //     }
    //  return recursion(0,1,k,prices,dp);
    return tabulation(prices,k);
    }

    int recursion(int i, int buy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0)
            return 0;
        if (i == prices.length)
            return 0;
        if (dp[i][buy][cap] != -1)
            return dp[i][buy][cap];
        if (buy == 1) {
            return dp[i][buy][cap] = Math.max(-prices[i] + recursion(i + 1, 0, cap, prices, dp),
                    recursion(i + 1, 1, cap, prices, dp));
        } else {
            return dp[i][buy][cap] = Math.max(prices[i] + recursion(i + 1, 1, cap - 1, prices, dp),
                    recursion(i + 1, 0, cap, prices, dp));
        }
    }
    int tabulation(int [] prices,int k){
     int [][][] dp=new int [prices.length+1][2][k+1];
     for(int i=prices.length-1;i>=0;i--){
        for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=k;cap++){
               if(buy==1){
             dp[i][buy][cap]=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
        }
        else{
            dp[i][buy][cap]=Math.max(prices[i]+dp[i+1][1][cap-1],dp[i+1][0][cap]);   
            }
        }
     }    
    }
    return dp[0][1][k];
}
}