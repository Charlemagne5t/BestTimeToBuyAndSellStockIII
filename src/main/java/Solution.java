import java.util.HashMap;

import java.util.Map;

public class Solution {
    public int maxProfit(int[] prices) {
        Integer[][][] memo = new Integer[2][2][100_002];
        return dfs(prices, 1, 0, 0, memo);
    }

    private int dfs(int[] prices, int ableToBuy, int numberOfTransactions, int index, Integer[][][] memo ) {
        if (numberOfTransactions == 2 || index == prices.length) {
            return 0;
        }
        if(memo[ableToBuy][numberOfTransactions][index] != null){
            return memo[ableToBuy][numberOfTransactions][index];
        }

        int result = 0;
        if (ableToBuy == 1) {
            int doNothing = dfs(prices, 1, numberOfTransactions, index + 1, memo);
            int buy = dfs(prices, 0, numberOfTransactions, index + 1, memo) - prices[index];
            result = Math.max(doNothing, buy);
        }
        if (ableToBuy == 0) {
            int doNothing = dfs(prices, 0, numberOfTransactions, index + 1, memo);
            int sell = prices[index] + dfs(prices, 1, numberOfTransactions + 1, index + 1, memo);
            result = Math.max(doNothing, sell);
        }
        memo[ableToBuy][numberOfTransactions][index] = result;
        return result;
    }
}
