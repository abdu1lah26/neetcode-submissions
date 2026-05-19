class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, res, list, target, 0, 0);
        return res;   
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int target, int i, int sum) {
        if(target == sum) {
            res.add(new ArrayList<>(list));
            return;
        }else if(sum > target && i < nums.length) return;

        if(i < nums.length) {
            list.add(nums[i]);
            sum += nums[i];
            dfs(nums, res, list,target, i, sum);

            sum -= list.get(list.size() - 1);
            list.remove(list.size() - 1);
            dfs(nums, res, list, target, i+1, sum);
        }
        return;
    }
}
