class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = cost[0];
        dp[1] = cost[1];
        return Math.min(f(n-1, cost, dp), f(n-2, cost, dp));
    }

    public int f(int idx, int[] cost, int[] dp) {
        if(idx == 0) return cost[0];
        if(idx == 1) return cost[1];
        if(dp[idx] != -1) return dp[idx];
        return dp[idx] = cost[idx] + Math.min(f(idx-1, cost, dp), f(idx-2, cost, dp));
    }
}
