class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 1) return false;
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = 0, p2 = 1;

        while(p2 < n) {
            if(nums[p2] == nums[p1]) return true;
            p2++;
            p1++;
        }
        return false;
    }
}