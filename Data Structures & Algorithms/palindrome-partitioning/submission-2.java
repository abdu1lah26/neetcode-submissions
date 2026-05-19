class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return res;
    }

    public void backtrack(int start, String s, List<String> list) {
        if(start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int end  = start; end<s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                list.add(s.substring(start, end+1));
                backtrack(end+1, s, list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int st, int e) {
        while(st < e) {
            if(s.charAt(st) != s.charAt(e)) return false;
            st++;
            e--;
        }
        return true;
    }
}
