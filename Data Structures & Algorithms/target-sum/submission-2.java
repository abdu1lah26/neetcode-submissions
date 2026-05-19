class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return f(n-1, target, nums);
    }

    public int f(int idx, int k, int[] nums) {
        if(idx < 0) {
            return k == 0 ? 1 : 0;
        }

        int cnt = 0;

        int plus = f(idx-1, k-nums[idx], nums);
        int minus = f(idx-1, k+nums[idx], nums);

        int res = plus + minus;

        return res;
    }
}
