class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int p1 = 0, p2 = 0, max = Integer.MIN_VALUE;
        int ans = 0;
        while(p2 < s.length()) {
            char ch = s.charAt(p2);
            freq[ch - 'A']++; 
            max = Math.max(max, freq[ch-'A']) ;

            int limit = p2-p1+1 - max;
            if(limit <= k) {
                ans = Math.max(ans, p2-p1+1);
            }else {
                freq[s.charAt(p1) - 'A']--;
                p1++;
            }
            p2++;
        }
        return ans;
    }
}
