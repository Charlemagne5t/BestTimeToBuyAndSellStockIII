import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void maxProfitTest1() {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int output = 6;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }

    @Test
    public void maxProfitTest2() {
        int[] prices = {1, 2, 3, 4, 5};
        int output = 4;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }

    @Test
    public void maxProfitTest3() {
        int[] prices = {7, 6, 4, 3, 1};
        int output = 0;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }
}
