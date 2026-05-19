class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, res, list, used);
        return res;
    }

    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            dfs(nums, res, list, used);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
