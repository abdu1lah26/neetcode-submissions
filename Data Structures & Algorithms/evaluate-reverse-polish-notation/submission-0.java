class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String ch : tokens) {
            if(ch.equals("+")) {
                int d2 = st.pop();
                int d1 = st.pop();
                st.push(d1+d2);
            }
            else if(ch.equals("*")) {
                int d2 = st.pop();
                int d1 = st.pop();
                st.push(d1*d2);
            }
            else if(ch.equals("-")) {
                int d2 = st.pop();
                int d1 = st.pop();
                st.push(d1-d2);
            }
            else if(ch.equals("/")) {
                int d2 = st.pop();
                int d1 = st.pop();
                st.push(d1/d2);
            }
            else {
                st.push(Integer.parseInt(ch));
            }
        }
        return st.pop();
    }
}
