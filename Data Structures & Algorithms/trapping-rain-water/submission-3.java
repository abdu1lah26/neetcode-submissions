class Solution {
    public int trap(int[] h) {
        int n = h.length;
        int l = 0, r = n-1, ans = 0;
        int lmax = h[l], rmax = h[r];
        while(l < r) {
            if(lmax < rmax) {
                l++;
                lmax = Math.max(lmax, h[l]);
                ans += lmax - h[l];
            }else {
                r--;
                rmax = Math.max(rmax, h[r]);
                ans += rmax - h[r];
            }
        }
        return ans;
    }
}
