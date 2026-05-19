class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] ht) {
        int row = ht.length;
        int col = ht[0].length;

        boolean[][] pac = new boolean[row][col];
        boolean[][] atl = new boolean[row][col];

        for(int r=0; r<row; r++) {
            dfs(r, 0, pac,ht);
            dfs(r, col-1, atl, ht);
        }

        for(int c=0; c<col; c++) {
            dfs(0, c, pac, ht);
            dfs(row-1, c, atl, ht);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(atl[r][c] && pac[r][c])
                res.add(Arrays.asList(r, c));
            }
        }

        return res;
    }
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(int r, int c, boolean[][] ocean, int[][] ht) {
        ocean[r][c] = true;
        for(int[] dir : directions) {
            int nr = r+dir[0], nc = c+dir[1];
            if(nr>=0 && nc>=0 && nr<ht.length && nc<ht[0].length && !ocean[nr][nc] && ht[nr][nc] >= ht[r][c]) {
                dfs(nr, nc, ocean, ht);
            }
        }
    }
}
