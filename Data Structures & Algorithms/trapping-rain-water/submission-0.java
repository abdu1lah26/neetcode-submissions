class Solution {
    public int trap(int[] h) {
        int n = h.length, ans = 0;
        for(int i=0; i<n; i++) {
            int leftmax = 0, rightmax = 0;
            int j=i;
            while(j >= 0) {
                leftmax = Math.max(leftmax, h[j]);
                j--;
            }
            j = i;
            while(j < n) {
                rightmax = Math.max(rightmax, h[j]);
                j++;
            }
            ans += Math.min(rightmax, leftmax) - h[i];
        }
        return ans;
    }
}
