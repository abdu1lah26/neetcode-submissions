class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int c : nums) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        
        for(int key : count.keySet()) {
            int val = count.get(key);
            if(bucket[val] == null) {
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
        int idx = 0;
        int ans[] = new int[k];
        for(int i=nums.length; i>=0 && idx < k; i--) {
            if(bucket[i] != null) {
                for(int val : bucket[i]) {
                    ans[idx++] = val;
                    if(idx == k) return ans;
                }
            }
        }
        return ans;
    }
}
