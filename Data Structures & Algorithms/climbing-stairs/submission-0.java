class Solution {
    public int climbStairs(int n) {
        return climb(n+1);
    }

    public int climb(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int left = climb(n-1);
        int right = climb(n-2);

        return left + right;
    }
}
