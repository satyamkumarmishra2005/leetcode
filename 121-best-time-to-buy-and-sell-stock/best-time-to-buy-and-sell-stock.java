class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int currentPrice : prices) {
            minPrice = Math.min(currentPrice, minPrice);
            maxProfit = Math.max(maxProfit, currentPrice - minPrice);
        }
        
        return maxProfit;
    }
}