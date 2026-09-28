class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][n + 1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        f(0, -1, dp, nums);
        return dp[0][0];
    }

    private int f(int i, int prevIdx, int[][] dp, int[] nums) {
        if(i == nums.length) return 0;

        if(dp[i][prevIdx + 1] != -1) return dp[i][prevIdx + 1];

        int take = 0;
        int skip = f(i + 1, prevIdx, dp, nums);

        if(prevIdx == -1 || nums[prevIdx] < nums[i])
            take = 1 + f(i + 1, i, dp, nums);

        return dp[i][prevIdx + 1] = Math.max(skip, take);
    }
}
