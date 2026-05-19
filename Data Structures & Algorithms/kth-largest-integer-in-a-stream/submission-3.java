class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();
        for(int n : nums) {
            pq.offer(n);
            if(pq.size() > k) pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > K) pq.poll();
        return pq.peek();
    }
}
