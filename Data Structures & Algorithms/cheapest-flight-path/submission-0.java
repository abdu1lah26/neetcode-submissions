class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights) {
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        Queue<int[]> q = new LinkedList<>();

        // stops, node, cost
        q.offer(new int[]{0, src, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        while(!q.isEmpty()) {

            int[] it = q.poll();

            int stops = it[0];
            int node = it[1];
            int cost = it[2];

            if(stops > k) continue;

            for(int[] ele : adj.get(node)) {

                int adjNode = ele[0];
                int edw = ele[1];

                if(cost + edw < dist[adjNode]) {

                    dist[adjNode] = cost + edw;

                    q.offer(new int[]{stops + 1, adjNode, cost + edw});
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}