class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {
            set.add(i);
        }

        if(set.size() == n) return false;
        return true;
    }
}