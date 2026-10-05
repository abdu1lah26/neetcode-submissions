class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int top = 0;
        int right = n - 1;
        int bottom = m - 1;
        int left = 0;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    list.add(matrix[j][left]);
                }
                left++;
            }
        }

        return list;
    }
}
