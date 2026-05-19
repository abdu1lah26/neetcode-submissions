class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

    public void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = '0';

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for(int[] dir : directions) {
                int nr = row+dir[0], nc = col+dir[1];
                if(nr>=0 && nc>=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
