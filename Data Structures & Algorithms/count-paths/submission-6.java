class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int i=0; i<m; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {

                if(j == 0) temp[0] = 1;
                else {
                    temp[j] = temp[j-1] + dp[j];
                }
            }
            dp = temp;
        }

        return dp[n-1];
    }
}
