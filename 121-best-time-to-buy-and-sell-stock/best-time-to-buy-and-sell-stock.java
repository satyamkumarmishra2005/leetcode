class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit =0;

        for(int currprice: prices){
            min = Math.min(currprice, min);
            profit = Math.max(profit, currprice-min);
        }
        return profit;
    }
}