class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;        
        int low = 0, high = m*n-1;

        while(low <= high) {
            int mid = low + (high - low)/2;
            int idx1 = mid/n;
            int idx2 = mid%n;

            if(matrix[idx1][idx2] < target) low = mid+1;
            else if(matrix[idx1][idx2] > target) high = mid-1;
            else {
                return true;
            }
        }
        return false;
    }
}
