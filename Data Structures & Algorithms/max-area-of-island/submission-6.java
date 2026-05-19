class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 1) {
                    int cnt = bfs(r, c, grid);
                    maxArea = Math.max(maxArea, cnt);
                }
            }
        }
        return maxArea;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int bfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = 0;
        int area = 0;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int cr = node[0], cc = node[1];
            area++;
            for(int[] nei : directions) {
                int nr = cr + nei[0], nc = cc + nei[1];

                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }

        return area;
    }
}
