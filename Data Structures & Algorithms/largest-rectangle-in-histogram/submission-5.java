class Solution {
    public int largestRectangleArea(int[] ht) {
        int n = ht.length;
        int pse[] = new int[n];
        int nse[] = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && ht[st.peek()] >= ht[i]) st.pop();

            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && ht[st.peek()] >= ht[i]) st.pop();

            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(max, ht[i] * (nse[i] - pse[i] - 1));
        }
        return max;
    }
}
