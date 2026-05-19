class Solution {
    class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n) {
            for(int i=0; i<n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findUPar(int node) {
            if(node == parent.get(node)) return node;

            int upl = findUPar(parent.get(node));
            parent.set(node, upl);
            return parent.get(node);
        }

        public boolean unionBySize(int u, int v) {
            int upl_u = findUPar(u); 
            int upl_v = findUPar(v);

            if(upl_u == upl_v) return false;
            if(size.get(upl_u) < size.get(upl_v)) {
                parent.set(upl_u, upl_v);
                size.set(upl_v, size.get(upl_v) + size.get(upl_u));
                
            }else {
                parent.set(upl_v, upl_u);
                size.set(upl_u, size.get(upl_v) + size.get(upl_u));
                
            }
            return true; 
        }
    }
    public int countComponents(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int res = n;
        for(int[] ed : edges) {
            if(ds.unionBySize(ed[0], ed[1])) res--;
        }
        return res;
    }
}
