// User function Template for Java

class Solution {
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int[][]dp=new int[val.length][capacity+1];
        for(int i=0;i<val.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return recursion(val.length-1,capacity,val,wt,dp); 
    }
    
    private static int recursion(int i,int cap,int val[],int wt[],int[][] dp){
        if(cap==0) return 0;
        if(i==0) {
            if(wt[0]<=cap) return (cap/wt[0])*val[0];
            else return (int) 0;
        }
        if(dp[i][cap]!=-1) return dp[i][cap];
        int pick=(int) -1e9;
        if(cap>=wt[i]){
            pick=val[i]+recursion(i,cap-wt[i],val,wt,dp);
        }
        int notPick=recursion(i-1,cap,val,wt,dp);
        return dp[i][cap]=Math.max(pick,notPick);
    }
}