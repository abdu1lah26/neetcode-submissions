class Solution {
    public int largestRectangleArea(int[] ht) {
        int maxArea = 0;
        for(int i = 0; i<ht.length; i++) {
            int minBar = Integer.MAX_VALUE, area = 1, cnt = 1;
            for(int j=i; j<ht.length; j++) {
                int bar = ht[j];
                minBar = Math.min(minBar, bar);
                area = cnt * minBar;
                cnt++;
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
