class Solution {
    public int minDistance(String word1, String word2) {
    //     int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    //     for (int[] dpi : dp) {
    //         Arrays.fill(dpi, -1);
    //     }
    //     return recursion(word1.length(), word2.length(), word1, word2, dp);
    return tabulation(word1,word2);
     }

    int recursion(int i, int j, String word1, String word2, int[][] dp) {
        if (i == 0)
            return j;
        if (j == 0)
            return i;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            return dp[i][j] = recursion(i - 1, j - 1, word1, word2, dp);
        } else {
            int insert = 1 + recursion(i, j - 1, word1, word2, dp);
            int delete = 1 + recursion(i - 1, j, word1, word2, dp);
            int replace = 1 + recursion(i - 1, j - 1, word1, word2, dp);
            return dp[i][j] = (Math.min(insert, Math.min(delete, replace)));
        }
    }

    int tabulation(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = (Math.min(insert, Math.min(delete, replace)));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}