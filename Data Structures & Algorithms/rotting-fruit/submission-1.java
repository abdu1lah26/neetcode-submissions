class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int min = -1;
        Queue<int[]> q = new LinkedList<>();

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while(!q.isEmpty()) {
            int size = q.size();
            min++;

            for(int i=0; i<size; i++) {
                int[] node = q.poll();
                int r = node[0], c = node[1];

                for(int[] dir : directions) {
                    int nr = r+dir[0], nc = c+dir[1];
                    if(nr<0 || nc<0 || nr>=row || nc>=col || grid[nr][nc] != 1) continue;
                    grid[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 1) {
                    return -1;
                }
            }
        }

        return min == -1 ? 0 : min;
        
    }
}
