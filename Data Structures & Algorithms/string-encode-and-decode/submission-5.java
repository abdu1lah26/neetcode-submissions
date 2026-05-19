class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String st : strs) {
            sb.append(st.length()).append('#').append(st);
        }
        
        return sb.toString();
    }

    public List<String> decode(String one) {
        List<String> list = new ArrayList<>();
        
        int i = 0;
        while(i < one.length()) {

            int delePos = one.indexOf('#', i);

            int length = Integer.parseInt(one.substring(i, delePos));

            String st = one.substring(delePos+1, delePos+1+length);

            list.add(st);

            i = delePos + 1 + length;
        }
        return list;
    }
}
