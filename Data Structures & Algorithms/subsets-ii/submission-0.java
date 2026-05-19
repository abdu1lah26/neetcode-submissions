class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }

    public void dfs(int[] nums, List<Integer> list, int i) {
        if(i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
            list.add(nums[i]);
            dfs(nums,list, i+1);
            list.remove(list.size() - 1);
            dfs(nums, list, i+1);
    }
}
