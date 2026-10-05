class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        boolean row0 = false;
        boolean col0 = false;

        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        for(int i = 0; i < col; i++) {
            if(matrix[0][i] == 0) {
                row0 = true;
                break;
            }
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++) {
            if(matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for(int i = 1; i < col; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 1; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        if(row0) Arrays.fill(matrix[0], 0);

        if(col0) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
