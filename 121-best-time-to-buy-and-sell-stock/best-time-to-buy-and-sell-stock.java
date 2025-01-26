class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for(int currprice: prices){
            minprice = Math.min(currprice, minprice);
            maxprofit = Math.max(maxprofit , currprice- minprice);
        }
        return maxprofit;
    }
}