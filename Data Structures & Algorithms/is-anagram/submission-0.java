class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m) return false;
        int freq[] = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for(char ch : t.toCharArray()) {
            freq[ch - 'a']--;
        }

        for(int ele : freq) {
            if(ele != 0) return false;
        }
        return true;
    }
}
