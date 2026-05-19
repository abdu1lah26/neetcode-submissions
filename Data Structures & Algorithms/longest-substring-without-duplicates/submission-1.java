class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), max = 0;
        for(int i=0; i<n; i++) {
            Set<Character> set = new HashSet<>();
            for(int j=i; j<n; j++) {
                if(!set.contains(s.charAt(j)))
                set.add(s.charAt(j));
                else 
                break;
            }
            max = Math.max(max, set.size());
        }
        return max;
    }
}
