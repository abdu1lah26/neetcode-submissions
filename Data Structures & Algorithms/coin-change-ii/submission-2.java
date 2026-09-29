class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        if(amount == 0) return 1; 

        int[][] dp = new int[n][amount + 1];
        for(int i = 0; i < n; i++) 
            Arrays.fill(dp[i], -1);

        f(0, amount, dp, coins);
        return dp[0][amount];
    }

    private int f(int i, int amt, int[][] dp, int[] coins) {
        if(amt == 0) return 1;
        if(i == coins.length) return 0;

        if(dp[i][amt] != -1) return dp[i][amt];

        int take = 0;
        if(amt >= coins[i])
            take = f(i, amt - coins[i], dp, coins);
        
        int skip = f(i + 1, amt, dp, coins);

        return dp[i][amt] = take + skip;
    }
}
