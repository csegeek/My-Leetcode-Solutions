class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        // for(int i=0;i<m;i++){
        //     Arrays.fill(dp[i],-1);
        // }
       //return recursion(0,0,m,n,dp,obstacleGrid);
        tabulation(m,n,dp,obstacleGrid);
        return dp[m-1][n-1];

    }
      private int recursion(int i,int j,int m,int n,int[][] dp,int[][]obstacleGrid){
        //base
        
        if(i>=m || j>=n) return 0;
        if(obstacleGrid[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        
        if(dp[i][j] !=-1) return dp[i][j];
        return dp[i][j]=recursion(i,j+1,m,n,dp,obstacleGrid)+recursion(i+1,j,m,n,dp,obstacleGrid) ;

    }

        private void tabulation(int m,int n,int[][] dp,int [][] obstacleGrid){
       
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) dp[i][j]=0;
                else if(i==0 && j==0) dp[i][j]=1;
                else {
                    int up=0;
                    int left=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=up+left;
                } 
                }  
            }
    }

}