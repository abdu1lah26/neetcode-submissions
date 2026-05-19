class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    public void dfs(char[][] grid, int r, int c) {
        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c] == '1') {
            grid[r][c] = '0';
            for(int[] dir : directions) {
                dfs(grid, r+dir[0], c+dir[1]);
            }
        }
    }
}
