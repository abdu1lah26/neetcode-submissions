class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, wordDict, 0, dp);
    }

    public boolean dfs(String s, List<String> dict, int i, int[] dp) {
        if (i == s.length())
            return true;

        if(dp[i] != -1) return dp[i] == 1;    

        for(String w : dict) {
            if(i + w.length() <= s.length() && s.substring(i, i+w.length()).equals(w)) {
                if(dfs(s, dict, i + w.length(), dp)) {
                    dp[i] = 1;
                     return true;
                }
            }
        }    
        dp[i] = 0;
        return false;
    }
}
