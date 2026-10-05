class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {

                if(i == j) continue;

                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        for(int[] row : matrix) {
            int left = 0;
            int right = n - 1;

            while(left < right) {
                int t = row[left];
                row[left] = row[right];
                row[right] = t;

                left++;
                right--;
            }
        }
    }
}
