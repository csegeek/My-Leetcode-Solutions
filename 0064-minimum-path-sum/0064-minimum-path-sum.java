class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
   // return recursive(m-1,n-1,grid,dp); 
   return tabulation(grid,dp,m,n);
    }

    private int recursive(int i,int j,int[][] grid,int[][]dp){
        if(dp[i][j]!=-1) return dp[i][j];
        if(i==0 && j==0){
            return dp[0][0]=grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(j>=1) up= recursive(i,j-1,grid,dp)+grid[i][j];
        if(i>=1) left=recursive(i-1,j,grid,dp)+grid[i][j];
        return dp[i][j]= Math.min(up,left);
    }

    private int tabulation(int[][]grid,int [][]dp,int m,int n){

       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            if(i==0 && j==0) dp[i][j]=grid[i][j];
            else if(i==0) dp[i][j]=grid[i][j]+dp[i][j-1];
            else if(j==0) dp [i][j]=grid[i][j]+dp[i-1][j];
            else{
               dp[i][j]= Math.min(grid[i][j]+dp[i-1][j],grid[i][j]+dp[i][j-1]);
            }
            }
        }
        return dp[m-1][n-1];

    }


}