class Solution {
    public int uniquePaths(int m, int n) {
        return f(m-1, n-1);
    }

    public int f(int m, int n) {
        if( m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        int left = f(m, n-1);
        int up = f(m-1, n);

        return left + up;
    }
}
