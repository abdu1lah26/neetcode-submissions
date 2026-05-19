class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int p1 = 0, p2 = 0, ans = 0;
        while(p2 < n) {
            char ch = s.charAt(p2);
            if(!set.contains(ch)) {
                p2++;
                set.add(ch);
            }else {
                set.remove(s.charAt(p1));
                p1++;
            }
            ans = Math.max(ans, p2-p1);
        }
        return ans;
    }
}
