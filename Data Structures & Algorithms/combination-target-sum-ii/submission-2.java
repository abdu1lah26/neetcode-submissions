class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return res;
    }
    int sum = 0;
    public void dfs(int[] nums, int target, List<Integer> list, int start) {
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }else if(sum > target) return;

        for(int i=start; i<nums.length; i++) {
            if(i>start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            sum += nums[i];
            dfs(nums, target, list, i+1);

            list.remove(list.size()-1);
            sum -= nums[i]; 
        }
    }
}
