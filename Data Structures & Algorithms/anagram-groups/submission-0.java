class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();


        for(String s : strs) {
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);

            boolean added = false;
            for(List<String> lt : result) {
                char[] s2Arr = lt.get(0).toCharArray();
                Arrays.sort(s2Arr);

                if(Arrays.equals(sArr, s2Arr)) {
                    lt.add(s);
                    added = true;
                    break;
                }
            }

            if(!added) {
                List<String> list = new ArrayList<>();
                list.add(s);
                result.add(list);
            }
        }
        return result;
    }
}
