class Solution {
    public int maxProfit(int[] prices) {
        // int[][] dp = new int[prices.length][2];
        // for (int[] dpi : dp) {
        //     Arrays.fill(dpi, -1);
        // }
        // return recursion(0, 1, prices, dp);
        return tabulation(prices);
    }

    int recursion(int i, int buy, int[] prices, int[][] dp) {
        if (i == prices.length)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        if (buy == 1) {
            return dp[i][buy] = Math.max(-prices[i] + recursion(i + 1, 0, prices, dp), recursion(i + 1, 1, prices, dp));
        } else {
            return dp[i][buy] = Math.max(prices[i] + recursion(i + 1, 1, prices, dp), recursion(i + 1, 0, prices, dp));
        }
    }

    int tabulation(int [] prices){
        int[][] dp=new int[prices.length+1][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
              if(buy==1){
            dp[i][buy]= Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
        }
        else{
            dp[i][buy]=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
        }   
            }
        }

        return dp[0][1];
        
    }
}