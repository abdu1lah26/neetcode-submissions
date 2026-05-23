class Solution {
    public int countSubstrings(String s) {
        int cnt = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                String st = s.substring(i, j + 1);
                if(palindrome(st)) cnt++;
            }
        }

        return cnt;
    }

    public boolean palindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            } else return false;
        }

        return true;
    }
}
