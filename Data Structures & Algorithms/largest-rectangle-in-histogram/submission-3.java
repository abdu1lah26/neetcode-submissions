class Solution {
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int max = 0;
        for(int i=0; i<n; i++) {
            int bar = ht[i];

            int right = i+1;
            while(right < n && ht[right] >= bar) right++;

            int left = i;
            while(left >=0 && ht[left] >= bar) left--;

            right--;
            left++;

            max = Math.max(max, bar * (right - left + 1));
        }
        return max;
    }
}
