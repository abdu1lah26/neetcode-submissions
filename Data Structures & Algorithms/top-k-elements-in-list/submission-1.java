class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int c : nums) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer, Integer> entry : count.entrySet()) {
        pq.add(entry);
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
