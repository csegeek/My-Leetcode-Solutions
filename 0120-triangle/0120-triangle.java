class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int m=triangle.size();
       int n=triangle.get(m-1).size();
       Integer[][] dp=new Integer[m][n];
    //    for(int i=0;i<m;i++){
    //     Arrays.fill(dp[i],-1);
    //    }
       return recursion(0,0,m,triangle,dp);
    }

    private int recursion(int i,int j,int m,List<List<Integer>>triangle,Integer[][] dp){
        if(dp[i][j]!=null) return dp[i][j];
       if(i==m-1){
        return triangle.get(i).get(j);
       }
       
       if(i<triangle.size() && j<triangle.get(i).size()){
        int dw=triangle.get(i).get(j)+recursion(i+1,j,m,triangle,dp);
        int diag=triangle.get(i).get(j)+recursion(i+1,j+1,m,triangle,dp);
        return dp[i][j]=Math.min(dw,diag);
       }
       return Integer.MAX_VALUE;
       }
}