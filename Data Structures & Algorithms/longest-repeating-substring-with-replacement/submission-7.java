class Solution {
    public int characterReplacement(String s, int k) {
        int p1 = 0, p2 = 0, maxfreq = 0;
        int n = s.length();
        int ans = 0;
        int[] freq = new int[26];
        while(p2 < n) {
            char ch = s.charAt(p2);
            freq[ch - 'A']++;
            maxfreq = Math.max(maxfreq, freq[ch-'A']);
            if(p2-p1+1 - maxfreq <= k) {
                ans = Math.max(ans, p2-p1+1);
            }else{
                freq[s.charAt(p1) - 'A']--;
                p1++;
            }
            p2++;
        }
        return ans;
    }
}
