class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1) return false;
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()) {

            if(ch == '(' || ch == '{' || ch == '[') st.push(ch);

            else {

                if(st.isEmpty()) return false;

                else {
                    if(ch == ')' && st.pop() != '(' ||
                     ch == ']' && st.pop() != '[' ||
                      ch == '}' && st.pop() != '{') 
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
