class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxLimit = 0;
        for(int n : piles) maxLimit = Math.max(maxLimit, n);
        int low = 1;
        int high = maxLimit;
        int k = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = low + (high - low) /2;
            int hrs = hour(piles, mid);
            if(hrs > h) {
                low = mid+1;
            }else if(hrs <= h) {
                high = mid-1;
                k = Math.min(k, mid);
            }
        }
        return k;
    }

    public int hour(int[] piles, int k) {
        int hr = 0;
        for(int n : piles) {
            hr += (n + k -1)/k;
        }
        return hr;
    }
}
