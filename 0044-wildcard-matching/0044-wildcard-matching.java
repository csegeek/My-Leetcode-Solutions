class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] dp=new Boolean[s.length()][p.length()];
        // for(int[] dpi:dp){
        //     Arrays.fill(dpi,-1);
        // }
        return recursion(s.length() - 1, p.length() - 1, s, p,dp);
    }

    boolean recursion(int i, int j, String s, String p,Boolean[][]dp) {
        if (i < 0 && j < 0)
            return true;
        if (i >= 0 && j < 0)
            return false;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j]=recursion(i - 1, j - 1, s, p,dp);
        } 
        else {
            if (p.charAt(j) == '*') {
                return dp[i][j]=recursion(i, j - 1, s, p,dp) || recursion(i - 1, j, s, p,dp);
            } 
            else
                return dp[i][j]=false;
        }

    }
}