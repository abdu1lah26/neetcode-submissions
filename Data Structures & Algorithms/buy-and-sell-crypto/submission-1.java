class Solution {
    public int maxProfit(int[] prices) {
        int p1 = 0, p2 = 0, max = 0;
        while(p2 < prices.length) {
            int buy = prices[p1];
            int sell = prices[p2];

            if(buy > sell) p1++;
            else if(buy <= sell) {
                max = Math.max(max, sell-buy);
                p2++;
            }
        }
        return max;
    }
}
