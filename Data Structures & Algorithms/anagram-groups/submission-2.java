class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(String st : strs) {
            char[] stArr = st.toCharArray();
            int [] check = new int[26];
            for(char c : stArr) {
                check[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int c : check) {
                sb.append(c).append('#');
            }
            
            String key = sb.toString();
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(st);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
