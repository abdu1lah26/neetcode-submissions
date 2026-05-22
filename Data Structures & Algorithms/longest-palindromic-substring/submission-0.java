class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        String st = "";
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                String checkString = s.substring(i, j + 1);

                if(palindrome(checkString) && ans < j - i + 1) {
                    ans = j - i + 1;
                    st = checkString;
                }
            }
        }

        return st;
    }

    public boolean palindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
