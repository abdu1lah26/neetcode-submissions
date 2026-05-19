class Solution {
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int max = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<=n; i++) {
            while(!st.isEmpty() && (i ==n || ht[st.peek()] >= ht[i])) {
                int h = ht[st.peek()];
                st.pop();

                int width = st.isEmpty() ? i : i - st.peek()-1;
                max = Math.max(max, h*(width));
            }
                st.push(i);
        }
        return max;
    }
}
