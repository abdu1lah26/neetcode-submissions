class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        int[] need = new int[126];
        for(char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int req = t.length();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right < s.length()) {
            char ch = s.charAt(right);

            if(need[ch] > 0) req--;
            need[ch]--;
            right++;

            while(req == 0) {
                if(right-left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                need[lc]++;
                if(need[lc] > 0) req++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
