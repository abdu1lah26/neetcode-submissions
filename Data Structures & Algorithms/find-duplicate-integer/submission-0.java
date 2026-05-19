class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) {
            if(!set.contains(n))
            set.add(n);
            else {
                return n;
            }
        }
        return -1;
    }
}
