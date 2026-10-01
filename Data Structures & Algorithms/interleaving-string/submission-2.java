class Solution {
    int n1, n2, n3;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        n1 = s1.length();
        n2 = s2.length();
        n3 = s3.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 0; i <= n1; i++) {
            Arrays.fill(dp[i], -1);
        }
        f(0, 0, dp, s1, s2, s3);
        return dp[0][0] == 1;
    }
    private boolean f(int i, int j, int[][] dp, String s1, String s2, String s3) {
        if(i == n1 && j == n2 && (i + j) == n3) {
        dp[i][j] = 1;
        return true;
        } 
        if((i + j) >= n3) return false;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean result = false;

        if(i < n1 && s1.charAt(i) == s3.charAt(i + j)) {
            result = f(i + 1, j, dp, s1, s2, s3);
            if(result) {
            dp[i][j] = 1;
            return true;
            } 
        }

        if(j < n2 && s2.charAt(j) == s3.charAt(i + j)) {
            result = f(i, j + 1, dp, s1, s2, s3);
            if(result) {
            dp[i][j] = 1;
            return true;
            } 
        }

        dp[i][j] =  0;
        return  false;
    }
}
