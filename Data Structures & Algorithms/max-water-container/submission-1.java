class Solution {
    public int maxArea(int[] h) {
        int l = 0, r = h.length-1, area = 0;
        while(l < r) {
            int minBar = Math.min(h[l], h[r]);
            area = Math.max(area, minBar*(r-l));
            if(h[l] < h[r]) l++;
            else r--;
        }
        return area;
    }
}
