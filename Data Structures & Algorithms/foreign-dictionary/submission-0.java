class Solution {
    public String foreignDictionary(String[] words) {
        int v = words.length;
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int[] indegree = new int[26];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] edge = new boolean[26][26];

        for (int i = 0; i < 26; i++) adj.add(new ArrayList<>());

        for (String word : words) {
            for (char c : word.toCharArray()) {
                set.add(c - 'a');
            }
        }

        for (int i = 0; i < v - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            if (!isLex(w1, w2, indegree, adj, edge))
                return "";
        }

        for (int i = 0; i < 26; i++) {
            if (set.contains(i) && indegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            sb.append((char) ('a' + curr));

            for (int nei : adj.get(curr)) {
                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        if (sb.length() != set.size())
            return "";

        return sb.toString();
    }

    private boolean isLex(
        String w1, String w2, int[] indegree, List<List<Integer>> adj, boolean[][] edge) {
        int l1 = w1.length();
        int l2 = w2.length();

        int i = 0, j = 0;

        while (i < l1 && j < l2) {
            if (w1.charAt(i) != w2.charAt(j)) {
                int u = w1.charAt(i) - 'a';
                int v = w2.charAt(j) - 'a';
                if (!edge[u][v]) {
                    adj.get(u).add(v);
                    indegree[v]++;
                    edge[u][v] = true;
                }
                return true;
            } else {
                i++;
                j++;
            }
        }

        if (l1 > l2)
            return false;

        return true;
    }
}