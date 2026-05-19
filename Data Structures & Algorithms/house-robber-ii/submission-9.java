class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if( n == 1 ) return nums[0]; 

        int prevFront = nums[0];
        int prev2Front = 0;

        for(int i=1; i<n-1; i++) {
            int left = nums[i];
            if(i>1) left += prev2Front;
            int right = prevFront;
            int curr = Math.max(left, right);
            prev2Front = prevFront;
            prevFront = curr;
        }

        
        int prevRear = nums[1];
        int prev2Rear = 0;
        for(int i=2; i<n; i++) {
            int left = nums[i];
            if(i>2) left += prev2Rear;
            int right = prevRear;
            int curr = Math.max(left, right);
            prev2Rear = prevRear;
            prevRear = curr;
        }
        
        return Math.max(prevRear, prevFront);
    }
}
