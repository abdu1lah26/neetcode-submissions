class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int n = nums.length;
        Arrays.sort(nums);
        int max = 0, curr = nums[0], streak = 0, i = 0;

        while(i < n) {
            if(curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            while(i < n && curr == nums[i]) {
                i++;
            }
            streak++;
            curr++;
            max = Math.max(max, streak);
        }
        return max;
    }
}
