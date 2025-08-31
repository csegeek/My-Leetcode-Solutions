class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return   tabulation(str1, str2);
    }

    String tabulation(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int i1 = 1; i1 <= text1.length(); i1++) {
            for (int i2 = 1; i2 <= text2.length(); i2++) {
                if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                } else {
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
                }
            }
        }

        int n = text1.length();
        int m = text2.length();
        int lenLcs = text1.length() + text2.length() - dp[n][m];
        int i = n;
        int j = m;
        StringBuilder res = new StringBuilder("");
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                res.append(text1.charAt(i - 1));
                i--;
                j--;
            } 
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(text1.charAt(i-1));
                i--;
            } 
            else {
                res.append(text2.charAt(j-1));
                j--;
            }
        }

        while(i>0){
            res.append(text1.charAt(i-1));
            i--;
        }
        while(j>0){
            res.append(text2.charAt(j-1));
            j--;
        }

        System.out.println(res);
        return res.reverse().toString();
    }

}