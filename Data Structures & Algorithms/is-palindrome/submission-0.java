class Solution {
    public boolean isPalindrome(String b) {
        if(b.length() <= 1) return true;
        String s = b.trim();
        s = b.toLowerCase();
        int n = s.length();
        int p1 = 0, p2 = n-1;
        while(p1 <= p2) {
            char cp1 = s.charAt(p1); 
            char cp2 = s.charAt(p2); 
            if(!Character.isLetterOrDigit(cp1)) {    
            p1++;
            continue;
            }
            if(!Character.isLetterOrDigit(cp2)) {
            p2--;
            continue;
            }
            if(Character.isWhitespace(cp1))p1++;
            if(Character.isWhitespace(cp2))p2--;
            if(cp1 == cp2) {
                p1++;
                p2--;
            }else return false;
        }
        return true;
    }
}
