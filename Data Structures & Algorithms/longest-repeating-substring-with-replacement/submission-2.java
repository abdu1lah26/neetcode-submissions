class Solution {
    public int characterReplacement(String s, int k) {
        int p1 = 0, p2 = 0;
        int n = s.length();
        int ans = 0;
        while(p2 < n) {
            String sub = s.substring(p1, p2+1);
            int limit = sub.length() - maxsame(sub);
            if(limit <= k) {
                ans = Math.max(ans, sub.length());
                p2++;
            }else {
                p1++;
            }
        }
        return ans;
    }

    public int maxsame(String sub) {
        int[] freq = new int[26];
        int max = 0;
        for(char ch : sub.toCharArray()) {
            freq[ch - 'A']++;
            max = Math.max(max, freq[ch-'A']);
        }
        return max;
    }
}
