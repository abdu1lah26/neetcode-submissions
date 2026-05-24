class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return dfs(0, dp, s);
    }

    public int dfs(int i, int[] dp, String s) {
        if(i >= s.length()) return 1;

        if(dp[i] != -1) return dp[i];

        if(s.charAt(i) == '0') return 0;

        int cnt = 0;
        cnt += dfs(i + 1, dp, s);

        if(i <= s.length() - 2) {
            int d1 = s.charAt(i) - '0';
            int d2 = s.charAt(i+1) - '0';

            if((d1*10 + d2) <= 26) {
                cnt += dfs(i + 2, dp, s);
            }
        }

        

        return dp[i] = cnt;
    }
}
