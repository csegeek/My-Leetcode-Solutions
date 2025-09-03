class Solution {
    public boolean isMatch(String s, String p) {
        Boolean [][] dp=new Boolean[s.length()+1][p.length()+1];
        return recursion(s.length(), p.length(), s, p,dp);
       // return tabulation(s, p);
    }

    boolean recursion(int i, int j, String s, String p, Boolean[][] dp) {
        if (i == 0 && j == 0)
            return true;
        if (i > 0 && j == 0)
            return false;
        if (i == 0 && j > 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*')
                    return false;
            }
            return true;
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = recursion(i - 1, j - 1, s, p, dp);
        } else {
            if (p.charAt(j - 1) == '*') {
                return dp[i][j] = recursion(i, j - 1, s, p, dp) || recursion(i - 1, j, s, p, dp);
            } else
                return dp[i][j] = false;
        }

    }

    boolean tabulation(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= p.length(); j++) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*')
                    dp[0][j] = false;
            }
            dp[0][j] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else
                        dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}