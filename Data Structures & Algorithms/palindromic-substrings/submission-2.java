class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(palindrome(s, i, j, dp)) cnt++;
            }
        }

        return cnt;
    }

    public boolean palindrome(String s, int i, int j, int[][] dp) {
        if(i >= j) return true;

        if(dp[i][j] != -1) return dp[i][j] == 1;

        if(s.charAt(i) == s.charAt(j)) {
            boolean ans = palindrome(s, i + 1, j - 1, dp);
            dp[i][j] = ans ? 1 : 0;
            return ans;
        }

        dp[i][j] = 0;
        return false;
    }
}
