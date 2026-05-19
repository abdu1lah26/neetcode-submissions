class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];

            for(int[] dir : directions) {
                int nr = r+dir[0], nc = c+dir[1];

                if(nr<0 || nc<0 || nr>=row || nc>=col || grid[nr][nc] != Integer.MAX_VALUE) continue;

                grid[nr][nc] = grid[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}
