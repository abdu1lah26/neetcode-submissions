class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        
        for(int[] row : points) {
            int dist = row[0]*row[0] + row[1]*row[1];
            pq.offer(new int[]{dist, row[0], row[1]});
            if(pq.size() > k) pq.poll();
        }
        int[][] ans = new int[k][2];

        for(int i=0; i<k; i++) {
            ans[i][0] = pq.peek()[1];
            ans[i][1] = pq.peek()[2];
            pq.poll();
        }

        return ans;
    }
}
