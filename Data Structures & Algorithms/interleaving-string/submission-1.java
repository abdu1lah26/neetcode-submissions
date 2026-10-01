class Solution {
    int n1, n2, n3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();

        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        for(int i = 0; i <= n1; i++) {
            for(int j = 0; j <= n2; j++)
                Arrays.fill(dp[i][j], -1);
        }
        f(0, 0, 0, dp, s1, s2, s3);
        return dp[0][0][0] == 1;
    }
    private boolean f(int i, int j, int k, int[][][] dp, String s1, String s2, String s3) {
        if(i == n1 && j == n2 && k == n3) {
        dp[i][j][k] = 1;
        return true;
        } 
        if(k >= n3) return false;

        if(dp[i][j][k] != -1) return dp[i][j][k] == 1;

        boolean result = false;

        if(i < n1 && s1.charAt(i) == s3.charAt(k)) {
            result = f(i + 1, j, k + 1, dp, s1, s2, s3);
            if(result) {
            dp[i][j][k] = 1;
            return true;
            } 
        }

        if(j < n2 && s2.charAt(j) == s3.charAt(k)) {
            result = f(i, j + 1, k + 1, dp, s1, s2, s3);
            if(result) {
            dp[i][j][k] = 1;
            return true;
            } 
        }

        dp[i][j][k] =  0;
        return  false;
    }
}
