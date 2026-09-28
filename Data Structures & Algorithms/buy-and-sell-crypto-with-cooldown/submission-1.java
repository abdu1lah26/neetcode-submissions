class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        f(0, true, dp, prices);
        return dp[0][1];
    }

    private int f(int i, boolean canBuy, int[][] dp, int[] prices) {
        if(i >= prices.length) return 0;

        if(dp[i][canBuy ? 1 : 0] != -1) return dp[i][canBuy ? 1 : 0];

        int money = 0;

        if(canBuy) {
            int buy = -prices[i] + f(i + 1, false, dp, prices);
            int skip = f(i + 1, true, dp, prices);
            return dp[i][1] = Math.max(buy, skip);
        } else {
            int sell = prices[i] + f(i + 2, true, dp, prices);
            int skip = f(i + 1, false, dp, prices);
            return dp[i][0] = Math.max(sell, skip);
        }
    }
}
