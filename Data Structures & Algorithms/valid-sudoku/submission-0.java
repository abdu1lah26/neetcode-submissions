class Solution {
    public boolean isValidSudoku(char[][] board) {
        

        for(int row = 0; row<9; row++) {
            Set<Character> seen = new HashSet<>();
            for(int col = 0; col<9; col++) {
                if(board[row][col] == '.') continue;
                else if(seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        for(int col = 0; col<9; col++) {
            Set<Character> seen = new HashSet<>();
            for(int row = 0; row<9; row++) {
                if(board[row][col] == '.') continue;
                else if(seen.contains(board[row][col])) return false;
                seen.add(board[row][col]);
            }
        }

        for(int sq = 0; sq<9; sq++) {
            Set<Character> seen = new HashSet<>();
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    int r = (sq/3)*3+i;
                    int c = (sq%3)*3+j;
                    if(board[r][c] == '.') continue;
                    else if(seen.contains(board[r][c])) return false;
                    seen.add(board[r][c]);
                }
            }
        }
        return true;
    }
}
