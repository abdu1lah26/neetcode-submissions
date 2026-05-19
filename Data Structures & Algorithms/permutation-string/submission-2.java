class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] small = s1.toCharArray();
        Arrays.sort(small);
        String sm = Arrays.toString(small);
        for(int i=0; i<s2.length(); i++) {
            for(int j=i; j<s2.length(); j++) {
                String sub = s2.substring(i, j+1);
                char[] s2sub = sub.toCharArray();
                Arrays.sort(s2sub);
                String lar = Arrays.toString(s2sub);
                if(lar.equals(sm)) return true;
            }
        }
        return false;
    }
}
