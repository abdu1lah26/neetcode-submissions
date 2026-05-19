class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) sum += i;

        if(sum%2 != 0) return false;
        int k = sum/2;
        boolean[][] dp = new boolean[n][k+1];

        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= k)
        dp[0][nums[0]] = true;

        for(int idx=1; idx<n; idx++) {
            for(int j=1; j<=k; j++) {

                boolean notTake = dp[idx-1][j];
                boolean take = false;

                if(j >= nums[idx]) {
                    take = dp[idx-1][j-nums[idx]];
                }
            dp[idx][j] = take || notTake;
            }

        }
        return dp[n-1][k];        
    }
}
