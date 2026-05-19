class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        Arrays.fill(dp, -1);
        return climb(n+1, dp);
    }

    public int climb(int n, int[] dp) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        int left = climb(n-1, dp);
        int right = climb(n-2, dp);

        return dp[n] = left + right;
    }
}
