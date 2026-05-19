class Solution {
    List<String> res = new ArrayList<>();
    String[] alpha = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        bt(0, "", digits);
        return res;
    }

    public void bt(int i, String cur, String digits) {
        if(i == digits.length()) {
            res.add(cur);
            return;
        }

        String alp = alpha[digits.charAt(i) - '0'];
        for(char ch : alp.toCharArray()) {
            bt(i+1, cur+ch, digits);
        }
    }
}
