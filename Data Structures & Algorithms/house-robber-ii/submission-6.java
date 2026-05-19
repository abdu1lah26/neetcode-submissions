class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1 ) return nums[0]; 

        int[] dpFront = new int[n-1];
        Arrays.fill(dpFront, -1);
        dpFront[0] = nums[0];

        int[] dpRear = new int[n];
        Arrays.fill(dpRear, -1);
        dpRear[1] = nums[1];

        return Math.max(keepFront(n-2, nums, dpFront), keepRear(n-1, nums, dpRear));
    }

    public int keepFront(int idx, int[] nums, int[] dp) {
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int left = nums[idx] + keepFront(idx-2, nums, dp);
        int right = 0 + keepFront(idx-1, nums, dp);

        return dp[idx] = Math.max(left, right);
    }
    public int keepRear(int idx, int[] nums, int[] dp) {
        if(idx == 1) return nums[1];
        if(idx < 1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int left = nums[idx] + keepRear(idx-2, nums, dp);
        int right = 0 + keepRear(idx-1, nums, dp);

        return dp[idx] = Math.max(left, right);
    }
}
