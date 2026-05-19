class Solution {
    int n;
    boolean[][] dp; 
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        n = s.length();
        dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j-i<=2 || dp[i+1][j-1]);
            }
        }
        dfs(s, dp, 0, res, new ArrayList<>());
        return res;
    }

    public void dfs(String s, boolean[][] dp, int start, List<List<String>> res, List<String> list) {
        if(start == n) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int end=start; end<n; end++) {
            if(dp[start][end]) {
                list.add(s.substring(start, end+1));
                dfs(s, dp, end+1, res, list);
                list.remove(list.size() - 1);
            }
        }
        return;
    }
}
