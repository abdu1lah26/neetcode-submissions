class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums.length == 1) return false;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            if(freq.containsKey(num)) return true;
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return false;
    }
}