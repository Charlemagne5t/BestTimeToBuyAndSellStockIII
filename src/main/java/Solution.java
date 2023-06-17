import java.util.HashMap;

import java.util.Map;

public class Solution {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(prices, true, 0, 0, memo);
    }

    private int dfs(int[] prices, boolean ableToBuy, int numberOfTransactions, int index, Map<String, Integer> memo ) {
        if (numberOfTransactions == 2 || index == prices.length) {
            return 0;
        }
        if(memo.containsKey(ableToBuy + " " + numberOfTransactions + " " + index)){
            return memo.get(ableToBuy + " " + numberOfTransactions + " " + index);
        }

        int result = 0;
        if (ableToBuy) {
            int doNothing = dfs(prices, true, numberOfTransactions, index + 1, memo);
            int buy = dfs(prices, false, numberOfTransactions, index + 1, memo) - prices[index];
            result = Math.max(doNothing, buy);
        }
        if (!ableToBuy) {
            int doNothing = dfs(prices, false, numberOfTransactions, index + 1, memo);
            int sell = prices[index] + dfs(prices, true, numberOfTransactions + 1, index + 1, memo);
            result = Math.max(doNothing, sell);
        }
        memo.put(ableToBuy + " " + numberOfTransactions + " " + index, result);
        return result;
    }
}
