class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;

        int[] dp = new int[nums.length + 1];
        dp[nums.length - 1] = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int end = Math.min(nums.length, i + nums[i]);

            for (int j = i + 1; j <= end; j++) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                }
            }
        }
        return dp[0] == 1;
    }
}
