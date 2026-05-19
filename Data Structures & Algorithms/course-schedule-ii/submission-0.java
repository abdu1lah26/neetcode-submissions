class Solution {
    public int[] findOrder(int numC, int[][] prereq) {
        boolean[] vis = new boolean[numC];
        boolean[] path = new boolean[numC];
        Stack<Integer> st = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numC; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prereq) {
            adj.get(pre[1]).add(pre[0]);
        }

        for(int i=0; i<numC; i++) {
            if(!vis[i]) {
                    if(dfs(i, adj, vis, path, st)) {
                        return new int[0];
                    }
            }
        }

        int[] ans = new int[numC];
        int i=0;
        while(!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }

    public boolean dfs(int node, List<List<Integer>> adj, boolean[] vis, boolean[] path, Stack<Integer> st) {
        vis[node] = true;
        path[node] = true;

        for(int nei : adj.get(node)) {
            if(!vis[nei]) {
                if(dfs(nei, adj, vis, path, st)) {
                    return true;
                }
            }else if (path[nei]) {
                return true;
            }
        }

        path[node] = false;
        st.add(node);
        return false;
    }
}
