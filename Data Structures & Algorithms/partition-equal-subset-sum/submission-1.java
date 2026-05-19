class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) sum += i;

        if(sum%2 != 0) return false;
        int k = sum/2;
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);

        return f(n-1, k, nums, dp);
    }

    public boolean f(int idx, int k, int[] nums, int[][] dp) {
        if(k == 0) return true;
        if(idx == 0) return nums[0] == k;

        if(dp[idx][k] != -1) return dp[idx][k] == 1;

        boolean notTake = f(idx-1, k, nums, dp);
        boolean take = false;

        if(k >= nums[idx]) {
            take = f(idx-1, k-nums[idx], nums, dp);
        }

        boolean ans = take || notTake;
        dp[idx][k] = ans ? 1 : 0;
        return ans;
    }
}
