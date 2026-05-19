class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 1) return false;
        HashSet<Integer> unique = new HashSet<>();
        for(int num : nums) {
            if(unique.contains(num)) return true;
            unique.add(num);
        }
        return false;
    }
}