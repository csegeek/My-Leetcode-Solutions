class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return recursiveSol(n,dp);
    }

    private int recursiveSol(int n,int [] dp){
        if(dp[n]!=-1) return dp[n];
        if(n==1) return 1;
        if(n==0) return 1;
        return dp[n]=recursiveSol(n-1,dp)+recursiveSol(n-2,dp);
    }
}