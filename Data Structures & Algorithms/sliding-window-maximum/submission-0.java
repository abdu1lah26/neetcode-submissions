class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for(int i = 0; i <= n - k; i++) {
            int maxi = nums[i];

            for(int j = i; j <= i + k - 1; j++) {
                maxi = Math.max(maxi, nums[j]);
            }

            ans[i] = maxi;
        }

        return ans;
    }
}
