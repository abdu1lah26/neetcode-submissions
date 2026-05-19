class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return money(nums, n-1, dp);
    }

    public int money(int[] nums, int ind, int[] dp) {
        if(ind == 0) return nums[0];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];
        int pick = nums[ind] + money(nums, ind-2, dp);
        int notpick = 0 + money(nums, ind-1, dp);

        return dp[ind] = Math.max(pick, notpick);
    }
}
