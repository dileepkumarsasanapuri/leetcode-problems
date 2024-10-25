class Solution {
    public String longestPalindrome(String s) {
         if (s == null || s.length() < 1) return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String longestPal = "";
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && (j - i + 1) > longestPal.length()) {
                        longestPal = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestPal;
    }
}