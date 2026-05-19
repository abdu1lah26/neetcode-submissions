class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lowidx = 0, highidx = n-1;
        while(lowidx <= highidx) {
            int mididx = lowidx + (highidx - lowidx)/2;
            if(target > nums[mididx]) lowidx = mididx+1;
            else if(target < nums[mididx]) highidx = mididx-1;
            else {
                return mididx;
            }
        }
        return -1;
    }
}
