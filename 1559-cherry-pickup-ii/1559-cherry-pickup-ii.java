class Solution {
    public int cherryPickup(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        Integer[][][] dp=new Integer[r][c][c];
        return recursion(0,0,c-1,grid,r,c,dp);
    }

    private int  recursion(int i,int j1,int j2,int [][] grid,int r,int c,Integer[][][] dp ){
        if(j1>=c || j1<0 || j2>=c || j2<0) return (int)-1e9;
        if(i==r-1) {
            if(j1==j2) return grid[i][j1];
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!= null) return dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        for(int d1=-1;d1<=1;d1++){
            for(int d2=-1;d2<=1;d2++){
                int temp=Integer.MIN_VALUE;
                if(j1==j2) temp= grid[i][j1]+ recursion(i+1,j1+d1,j2+d2,grid,r,c,dp);
                else{
                    temp=grid[i][j1]+grid[i][j2]+recursion(i+1,j1+d1,j2+d2,grid,r,c,dp);
                }
                max=Math.max(temp,max);
            } 
        }
         return dp[i][j1][j2] =max;
    }

}