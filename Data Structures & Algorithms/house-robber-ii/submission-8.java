class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1 ) return nums[0]; 

        int[] dpFront = new int[n-1];
        Arrays.fill(dpFront, -1);
        dpFront[0] = nums[0];

        for(int i=1; i<n-1; i++) {
            int left = nums[i];
            if(i>1) left += dpFront[i-2];
            int right = dpFront[i-1];
            dpFront[i] = Math.max(left, right);
        }

        int[] dpRear = new int[n];
        Arrays.fill(dpRear, -1);
        dpRear[1] = nums[1];
        for(int i=2; i<n; i++) {
            int left = nums[i];
            if(i>2) left += dpRear[i-2];
            int right = dpRear[i-1];
            dpRear[i] = Math.max(left, right);
        }
        return Math.max(dpFront[n-2], dpRear[n-1]);
    }
}
