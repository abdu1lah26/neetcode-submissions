class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, list, 0);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list,  int limit) {
        if(limit == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[limit]);
        dfs(nums, res, list, limit + 1);

        list.remove(list.size() - 1);
        dfs(nums, res, list, limit+1);
    }
}
