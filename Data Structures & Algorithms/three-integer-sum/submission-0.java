class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        for(int k=0; k<nums.length; k++) {
            for(int i=k+1; i<nums.length; i++) {
                for(int j=i+1; j<nums.length; j++) {
                    if(nums[k] + nums[i] + nums[j] == 0) {
                        List<Integer> ans = Arrays.asList(nums[k], nums[i], nums[j]);
                        res.add(ans);
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
}
