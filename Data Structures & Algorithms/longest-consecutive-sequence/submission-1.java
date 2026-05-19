class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;

        for(int num : nums) 
            set.add(num);

        for(int num : nums) {

            if(set.contains(num+1)) {
                int cnt = 1, next = num;
                while(set.contains(next+1)) {
                    cnt++;
                    next++;
                }
                max = Math.max(max, cnt);
            }else {
                max = Math.max(max, 1);
            }

        }
        return max;
    }
}
