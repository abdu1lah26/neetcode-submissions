class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(Math.min(start0(n-1, cost), start0(n-2, cost)), Math.min(start1(n-1, cost), start1(n-2, cost)));
    }

    public int start0(int idx, int[] cost) {
        if(idx == 0) return cost[0];
        if(idx < 0) return 0;

        int left = cost[idx] + start0(idx-1, cost);
        int right = Integer.MAX_VALUE;
        if(idx > 1)
        right = cost[idx] + start0(idx-2, cost);

        return Math.min(left, right);
    }
    public int start1(int idx, int[] cost) {
        if(idx == 1) return cost[1];
        if(idx < 1) return Integer.MAX_VALUE;

        int left = cost[idx] + start1(idx-1, cost);
        int right = Integer.MAX_VALUE;
        if(idx > 2)
        right = cost[idx] + start1(idx-2, cost);

        return Math.min(left, right);
    }
}
