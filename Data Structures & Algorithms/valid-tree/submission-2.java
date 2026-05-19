class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] i: edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        if(dfs(0, -1, adj, vis)) return false;
        
        for(boolean v : vis) {
            if(!v) return false;
        }


        return true;
    }

    public boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for(int nei : adj.get(node)) {
            if(!vis[nei]) {
                if(dfs(nei, node, adj, vis)) return true;
            }else if(nei != parent) return true;
        }
        return false;
    }
}
