class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        Integer[][] dp = new Integer[n][n];
        // for(int i=0;i<n;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int temp = recursion(0, j, matrix, n, dp);
            if (temp < minSum)
                minSum = temp;
        }
        return tabulation(matrix,n);
    }

    private int recursion(int i, int j, int[][] matrix, int n, Integer[][] dp) {
        if (i == n - 1) {
            return matrix[i][j];
        }
        if (dp[i][j] != null)
            return dp[i][j];
        //dialeft;
        int diaLeft = Integer.MAX_VALUE;
        if (j > 0)
            diaLeft = matrix[i][j] + recursion(i + 1, j - 1, matrix, n, dp);
        //down
        int down = matrix[i][j] + recursion(i + 1, j, matrix, n, dp);
        //diaRight
        int diaRight = Integer.MAX_VALUE;
        if (j < n - 1)
            diaRight = matrix[i][j] + recursion(i + 1, j + 1, matrix, n, dp);
        return dp[i][j] = Math.min(diaLeft, Math.min(down, diaRight));
    }

    private int tabulation(int[][] matrix, int n) {
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int diaLeft = Integer.MAX_VALUE;
                if (j<n-1)
                    diaLeft = matrix[i][j] + dp[i-1][j+1];
                //down
                int down = matrix[i][j] + dp[i-1][j];
                //diaRight
                int diaRight = Integer.MAX_VALUE;
                if (j >0)
                    diaRight = matrix[i][j] + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(diaLeft, Math.min(down,diaRight));
            }
        }
       int min=Integer.MAX_VALUE;
       for(int j=0;j<n;j++){
        int temp=dp[n-1][j];
        if(temp<min) min=temp;
       }
       return min;
    }
}