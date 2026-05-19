class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for(int r=0; r<row; r++) {
            for(int c=0; c<col; c++) {
                if(grid[r][c] == 1) {
                    int cnt = dfs(r, c, grid);
                    maxArea = Math.max(maxArea, cnt);
                }
            }
        }
        return maxArea;
    }

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int dfs(int r, int c, int[][] grid) {
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        int area = 1;

        for(int[] nei : directions) {
            area += dfs(r+nei[0], c+nei[1], grid);
        }

        return area;
    }
}
