class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, target, 0, new ArrayList<>());
        return ans;
    }
    int sum = 0;
    public void dfs(int[] nums, int target, int i, List<Integer> list) {
        if(target == sum) {
            ans.add(new ArrayList<>(list));
            return;
        }else if(sum > target) return;

        if(i<nums.length) {
            list.add(nums[i]);
            sum += nums[i];

            dfs(nums, target, i, list);

            sum -= nums[i];
            list.remove(list.size() - 1);
            dfs(nums, target, i+1, list);
        }
        return;
    }
}
