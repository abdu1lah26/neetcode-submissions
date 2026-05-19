class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) sum += i;

        if(sum%2 != 0) return false;

        return f(n-1, sum/2, nums);
    }

    public boolean f(int idx, int k, int[] nums) {
        if(k == 0) return true;
        if(idx == 0) return nums[0] == k;

        boolean notTake = f(idx-1, k, nums);
        boolean take = false;

        if(k >= nums[idx]) {
            take = f(idx-1, k-nums[idx], nums);
        }

        return take || notTake;
    }
}
