class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        return Math.min(f(n-1, cost), f(n-2, cost));
    }

    public int f(int idx, int[] cost) {
        if(idx == 0) return cost[0];
        if(idx == 1) return cost[1];

        return cost[idx] + Math.min(f(idx-1, cost), f(idx-2, cost));
    }
}
