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
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 'O')
            return;

            board[r][c] = 'S';
            for(int[] dir : directions) {
                dfs(r+dir[0], c+dir[1], board);
            }
    }
}