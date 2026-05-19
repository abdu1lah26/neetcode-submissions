class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];

        prefixMax[0] = h[0];
        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], h[i]);
        }

        suffixMax[n-1] = h[n-1];
        for(int i = n-2; i>=0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], h[i]);
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            result += Math.min(prefixMax[i], suffixMax[i]) - h[i];
        }
        return result;
    }
}
