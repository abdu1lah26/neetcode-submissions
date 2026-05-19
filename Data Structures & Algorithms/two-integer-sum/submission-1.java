class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       HashMap<Integer, Integer> checkDiff = new HashMap<>();

       for(int i=0; i<n; i++) {
        int prev = target - nums[i];
        if(checkDiff.containsKey(prev)) return new int[]{checkDiff.get(prev), i};
        checkDiff.put(nums[i], i);
       }
       return new int[]{};
    }
}
