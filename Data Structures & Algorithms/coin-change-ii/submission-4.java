class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        if (amount == 0)
            return 1;

        int[] next = new int[amount + 1];
        int[] curr = new int[amount + 1];
        next[0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int amt = 0; amt <= amount; amt++) {
                int take = 0;
                if (amt >= coins[i])
                    take = curr[amt - coins[i]];

                int skip = next[amt];

                curr[amt] = take + skip;
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[amount];
    }
}
