class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones) pq.offer(s);

        if(pq.size() == 1) return pq.poll();

        while(pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if(s1 == s2) continue;
            else if(s1 < s2) pq.offer(s2 - s1);
            else if(s1 > s2) pq.offer(s1 - s2);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
