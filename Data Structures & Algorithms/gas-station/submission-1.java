class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalgas = 0;
        for (int g : gas) totalgas += g;

        int totalcost = 0;
        for (int cst : cost) totalcost += cst;

        if (totalgas < totalcost)
            return -1;

        int result = 0;
        int tank = 0;

        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];

            if (tank < 0) {
                result = i + 1;
                tank = 0;
            }
        }
        return result;
    }
}
