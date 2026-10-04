class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIdx = new int[26];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIdx[ch - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            end = Math.max(end, lastIdx[ch - 'a']);

            if(i == end) {
                list.add(end - start + 1);
                start = i + 1;
            }
        }

        return list;
    }
}
