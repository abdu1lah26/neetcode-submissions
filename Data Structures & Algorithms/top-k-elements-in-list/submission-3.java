class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int c : nums) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        pq.addAll(count.entrySet());

        
        int[] ans = new int[k];
        int size = pq.size()-k;
        for(int i=0; i<size; i++) {
             pq.poll();
        }
        for(int i=0; i<k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
