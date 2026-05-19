class Solution {
    List<String> res = new ArrayList<>();
    String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        bt(0, "", digits);
        return res;
    }
    public void bt(int i , String cur, String digits) {
        if(cur.length() == digits.length()) {
            res.add(cur);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()) {
            bt(i+1, cur+c, digits);
        }
    }
}
