package offer.no63;

/**
 * @author Toreno Li
 * 遍历时记录之前的最小值,若当前的值比最小值小,则更新最小值,反之计算result
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= minPrice) {
                minPrice = prices[i];
            } else {
                result = Math.max(prices[i] - minPrice, result);
            }
        }
        return result;
    }
}
