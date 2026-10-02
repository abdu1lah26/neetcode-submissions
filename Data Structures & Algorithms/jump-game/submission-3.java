class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length == 1) return true;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        dfs(0, dp, nums);
        return dp[0] == 1;
    }

    private boolean dfs(int i, int[] dp, int[] nums) {
        if(i >= nums.length - 1) return true;

        if(dp[i] != -1) return dp[i] == 1;

        int end = Math.min(nums.length, i + nums[i]);

        for(int j = i + 1; j <= end; j++) {
            
            if(dfs(j, dp, nums)) {
                dp[i] = 1;
                return true;
            }

        }

        dp[i] = 0;
        return false;
    }
}
