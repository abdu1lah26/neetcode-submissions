class Solution {
    public int[] findOrder(int numC, int[][] prereq) {
        int[] ind = new int[numC];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<numC; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prereq) {
            adj.get(pre[0]).add(pre[1]);
            ind[pre[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numC; i++) {
            if(ind[i] == 0) q.add(i);
        }

        int finish = 0;
        int[] output = new int[numC];
        while(!q.isEmpty()) {
            int node = q.poll();
            output[numC-finish-1] = node;
            finish++;
            for(int nei : adj.get(node)) {
                ind[nei]--;
                if(ind[nei] == 0) q.add(nei);
            }
        }

        if(finish != numC) return new int[0];
        return output;
    }
}
