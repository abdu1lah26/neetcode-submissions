class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), vis);
        return res;
    }

    public void dfs(int[] nums, List<Integer> list, boolean[] vis) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!vis[i]) {
                list.add(nums[i]);
                vis[i] = true;
                dfs(nums, list, vis);

                list.remove(list.size()-1);
                vis[i] = false;
            }
        }
    }    
}
