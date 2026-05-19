class Solution {
    public boolean canFinish(int numC, int[][] prereq) {
        if(numC < 2) return true;
        List<List<Integer>> adjL = new ArrayList<>();
        boolean[] vis = new boolean[numC];
        boolean[] pathVis = new boolean[numC];

        for(int i=0; i<numC; i++) {
            adjL.add(new ArrayList<>());
        }
        for(int[] pre : prereq) {
            adjL.get(pre[1]).add(pre[0]);
        }

        for(int i=0; i<numC; i++) {
            if(!vis[i]) {
                if(dfs(i, adjL, vis, pathVis)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, List<List<Integer>> adjL, boolean[] vis, boolean[] pathVis) {
        vis[node] = true;
        pathVis[node] = true;

        for(int nei : adjL.get(node)) {
            if(!vis[nei]) {
                if (dfs(nei, adjL, vis, pathVis))
                return true;
            }else if (pathVis[nei]) {
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}
