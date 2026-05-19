class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0; i<=n; i++) adj.add(new ArrayList<>());

        for(int[] i : times) {
            adj.get(i[0]).add(new int[]{i[1], i[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        int[] dist = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[0] = 0;
        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            for(int[] nei : adj.get(node)) {
                int nwt = nei[1];
                int newNode = nei[0];

                if(wt + nwt < dist[newNode]) {
                    dist[newNode] = wt+nwt;
                    pq.offer(new int[]{dist[newNode], newNode});
                }
            }
        }
        for(int i : dist) {
            if(i == (int)1e9) {
                return -1;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : dist) {
            max = Math.max(max, i);
        }
        return max;
    }
}
