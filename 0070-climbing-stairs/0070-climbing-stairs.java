class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        //Arrays.fill(dp,-1);
       // return recursiveSol(n,dp);

       //Tabulation
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }


 //memoization
    private int recursiveSol(int n,int [] dp){
        if(dp[n]!=-1) return dp[n];
        if(n==1) return 1;
        if(n==0) return 1;
        return dp[n]=recursiveSol(n-1,dp)+recursiveSol(n-2,dp);
    }
}