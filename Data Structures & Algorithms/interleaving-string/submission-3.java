class Solution {
    int n1, n2, n3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        dp[n1][n2] = 1;

        for (int i = n1; i >= 0; i--) {
            for (int j = n2; j >= 0; j--) {
                if (i == n1 && j == n2)
                    continue;

                boolean result = false;

                if (i < n1 && s1.charAt(i) == s3.charAt(i + j)) {
                    result = (dp[i + 1][j] == 1);
                    if (result) {
                        dp[i][j] = 1;
                    }
                }

                if (j < n2 && s2.charAt(j) == s3.charAt(i + j)) {
                    result = (dp[i][j + 1] == 1);
                    if (result) {
                        dp[i][j] = 1;
                    }
                }

                if (dp[i][j] != 1)
                    dp[i][j] = 0;
            }
        }

        return dp[0][0] == 1;
    }
}
