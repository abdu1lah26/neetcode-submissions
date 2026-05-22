class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        int n = s.length();
        int max = 0;
        String ans = "";

        for (int i = 0; i < n - 1; i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);

            if (odd.length() > max) {
                max = odd.length();
                ans = odd;
            }
            if (even.length() > max) {
                max = even.length();
                ans = even;
            }
        }

        return ans;
    }

    public String expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i + 1, j);
    }
}
