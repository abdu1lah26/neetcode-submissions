class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (r == 0) {
                    if (board[r][c] == 'O') {
                        dfs(r, c, board);
                    }
                } else if (c == 0) {
                    if (board[r][c] == 'O') {
                        dfs(r, c, board);
                    }
                } else if (r == row - 1) {
                    if (board[r][c] == 'O') {
                        dfs(r, c, board);
                    }
                } else if (c == col - 1) {
                    if (board[r][c] == 'O') {
                        dfs(r, c, board);
                    }
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public void dfs(int r, int c, char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        board[r][c] = 'S';

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int rr = node[0], cc = node[1];   

            for(int[] dir : directions) {
                int nr = rr+dir[0], nc = cc+dir[1];
                if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O') {
                    q.add(new int[]{nr, nc});
                    board[nr][nc] = 'S';
                }
            }
        }
    }
}