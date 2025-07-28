class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        Integer[][] dp=new Integer[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        int minSum=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
        int temp=recursion(0,j,matrix,n,dp);
        if(temp<minSum) minSum=temp;
        }
        return minSum;
    }

    private int recursion(int i,int j,int[][] matrix,int n,Integer[][] dp){
      if(i==n-1){
        return matrix[i][j];
      }  
      if(dp[i][j] !=null) return dp[i][j];
      //dialeft;
      int diaLeft=Integer.MAX_VALUE;
      if(j>0) diaLeft=matrix[i][j]+recursion(i+1,j-1,matrix,n,dp);
      //down
      int down=matrix[i][j]+recursion(i+1,j,matrix,n,dp);
      //diaRight
      int diaRight=Integer.MAX_VALUE;
      if(j<n-1) diaRight=matrix[i][j]+recursion(i+1,j+1,matrix,n,dp);
      return dp[i][j]=Math.min(diaLeft,Math.min(down,diaRight));
    }
}