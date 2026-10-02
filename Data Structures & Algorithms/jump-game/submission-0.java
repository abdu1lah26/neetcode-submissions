class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if(max >= n - 1) return true;

            if(i <= max) {
                max = Math.max(max, i + nums[i]);
            }
        }

        return max >= n - 1 ? true : false;
    }
}
