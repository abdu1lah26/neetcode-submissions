class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(0, 0, n, sb, ans);
        return ans;
    }

    public void backtrack(int open, int close, int n, StringBuilder sb, List<String> ans) {
        if(2*n == open + close) {
            ans.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append('(');
            backtrack(open+1, close, n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open) {
            sb.append(')');
            backtrack(open, close+1, n, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
