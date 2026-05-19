class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length(), ans = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                String sub = s.substring(i, j+1);
                int limit = sub.length() - maxsame(sub);
                if(limit <= k) {
                    ans = Math.max(ans, sub.length());
                }
            }
        }
        return ans;
    }
    public int maxsame(String sub) {
        int[] freq = new int[26];
        int max = 0;
        for(char ch : sub.toCharArray()) {
            freq[ch - 'A']++;
            max = Math.max(max, freq[ch - 'A']);
        }
        return max;
    }
}
