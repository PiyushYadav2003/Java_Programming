class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // Track the lowest price seen so far
        int maxProfit = 0;                // Track the highest profit found
        
        for (int price : prices) {
            // If we find a new lowest price, update minPrice
            if (price < minPrice) {
                minPrice = price;
            } 
            // Otherwise, check if selling today yields a better profit
            else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
}
