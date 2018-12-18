public class maxProfit {

    /*
        Find max profit for stocks (7,1,2,3,1,7)
     */

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                //if there is a deficit
                if (prices[i] > prices[i + 1]) {
                    continue;
                }
                if (prices[i] < prices[i + 1]) {
                    //buy and sell if you make a profit
                    sum += (prices[i + 1] - prices[i]);
                }
            } else {
                if (prices[i - 1] > prices[i]) {
                    continue;
                }
                if (prices[i - 1] < prices[i]) {
                    //buy and sell if you make a profit
                    sum += (prices[i] - prices[i - 1]);
                }
            }
        }
        return sum;
    }
}
