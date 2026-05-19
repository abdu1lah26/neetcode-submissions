class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, res, list, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> list, int sum, int start) {
        if(target == sum ) {
            res.add(new ArrayList<>(list));
            return;
        }else if(sum > target) return;

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) continue;

            list.add(nums[i]);
            dfs(nums, target, res, list, sum + nums[i], i+1);
            list.remove(list.size() - 1);
        }
    }
}
