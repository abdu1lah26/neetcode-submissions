class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, r, c));
                }
            }
        }
        return maxArea;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        int area = 1;
        grid[r][c] = 0;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int rr = node[0], cc = node[1];

            for(int[] dir : directions) {
                int nr = rr + dir[0], nc = cc + dir[1];
                if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == 1) {
                    area = area +1;
                    grid[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                }
            }
        }
            return area;
    }
}
