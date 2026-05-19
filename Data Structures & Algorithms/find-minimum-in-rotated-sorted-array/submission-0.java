class Solution {
    public int findMin(int[] nums) {
       int l = 0;
       int r = nums.length-1;
       int min = Integer.MAX_VALUE;
       while(l <= r) {
        int mid = (l+r)/2;
        if(nums[l] <= nums[mid]) {
            min = Math.min(min, nums[l]);
            l = mid + 1;
        }
        else if(nums[mid] <= nums[r]) r = mid - 1;
        min = Math.min(min, nums[mid]);
       } 
       return min;
    }
}
