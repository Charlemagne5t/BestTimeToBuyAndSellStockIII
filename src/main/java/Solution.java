public class Solution {
    public int maxProfit(int[] prices) {

        return dfs(prices, true, 0, 0);
    }

    private int dfs(int[] prices, boolean ableToBuy, int numberOfTransactions, int index) {
        if (numberOfTransactions == 2 || index == prices.length) {
            return 0;
        }

        int result = 0;
        if (ableToBuy) {
            int doNothing = dfs(prices, true, numberOfTransactions, index + 1);
            int buy = dfs(prices, false, numberOfTransactions, index + 1) - prices[index];
            result = Math.max(doNothing, buy);
        }
        if (!ableToBuy) {
            int doNothing = dfs(prices, false, numberOfTransactions, index + 1);
            int sell = prices[index] + dfs(prices, true, numberOfTransactions + 1, index + 1);
            result = Math.max(doNothing, sell);
        }

        return result;
    }
}
