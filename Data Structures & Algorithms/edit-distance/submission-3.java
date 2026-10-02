class Solution {
    public int minDistance(String s1, String s2) {
        if (s1.equals(s2))
            return 0;
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int j = 0; j <= n2; j++) dp[n1][j] = n2 - j;

        for (int i = 0; i <= n1; i++) dp[i][n2] = n1 - i;

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];

                } else {
                    int delete = 1 + dp[i + 1][j];

                    int insert = 1 + dp[i][j + 1];

                    int replace = 1 + dp[i + 1][j + 1];

                    dp[i][j] = Math.min(delete, Math.min(insert, replace));
                }
            }
        }

        return dp[0][0];
    }
}
