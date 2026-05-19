class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int num : nums) set.add(num);
        for(int num : nums) {
            if(!set.contains(num-1)) {
                int cnt = 0;
                while(set.contains(num)) {
                    cnt++;
                    num++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
