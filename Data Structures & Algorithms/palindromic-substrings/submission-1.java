class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(palindrome(s, i, j)) cnt++;
            }
        }

        return cnt;
    }

    public boolean palindrome(String s, int i, int j) {
        if(i > j) return true;

        if(s.charAt(i) == s.charAt(j)) {
            return palindrome(s, i + 1, j - 1);
        }

        return false;
    }
}
