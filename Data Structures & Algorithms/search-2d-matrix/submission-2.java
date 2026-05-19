class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        for(int[] row : matrix) {
            if(row[(c-1)/2] >= row[0] && row[(c-1)/2] <= row[c-1]) {
                int low = 0, high = c-1;
                while(low <= high) {
                    int mid = (low+high)/2;
                    if(row[mid] > target) high = mid-1;
                    else if(row[mid] < target) low = mid+1;
                    else return true;
                }
            }
        }
        return false;
    }
}
