class Solution {
    public int trap(int[] h) {
       int n = h.length, ans = 0; 
       Stack<Integer> st = new Stack<>();
       for(int right=0; right<n; right++) {
          while(!st.isEmpty() && h[right] > h[st.peek()]) {
            int mid = st.pop();
            if(st.isEmpty()) break;
            int left = st.peek();
            int width = right-left-1;
            int min = Math.min(h[right], h[left]) - h[mid];
            ans += min*width;
          }
          st.push(right);
       }
       return ans;
    }
}
