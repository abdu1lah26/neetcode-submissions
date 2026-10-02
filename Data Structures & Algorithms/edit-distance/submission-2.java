class Solution {
    public int minDistance(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1][n2];
        for(int i = 0; i < n1; i++)
            Arrays.fill(dp[i], -1);

        return f(0, 0, dp, s1, s2);
    }

    private int f(int i, int j, int[][] dp, String s1, String s2) {
        if (i == s1.length()) {
            return s2.length() - j;
        }

        if (j == s2.length()) {
            return s1.length() - i;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = f(i + 1, j + 1, dp, s1, s2);
        }

        int delete = 1 + f(i + 1, j, dp, s1, s2);

        int insert = 1 + f(i, j + 1, dp, s1, s2);

        int replace = 1 + f(i + 1, j + 1, dp, s1, s2);

        return dp[i][j] = Math.min(delete, Math.min(insert, replace));
    }
}
