class Solution {
    public int maxProfit(int[] prices) {
        /* Notes
        take array of prices, index is the day
        find the max profit, meaning max - min within a range (cannot go backwards)
        */
        
        /* Questions
        Duplicate prices can be present right? (Yes)
        */
        
        /* Approach
        int stores max profit
        for loop iterates through array of prices
            nested for loop iterates through future prices
                if statement checks max < future price - current price
                    set max = future - current
        return max profit
        */
        
        /*
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (max < prices[j] - prices[i]) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
        */
        
        
        /* Tests
        [1,2,3] -> i = 0, j = 1, 2 - 1 = 1 > 0, max = 1; j = 2, 3 - 1 = 2 > 1, max = 2;
        i = 1, j = 2, 3 - 2 = 1 < 2 -> return 2
        */
        
        /* Optimize
        O(n^2) runtime, iterates through nested loop based on given array length
        O(1) space, no additional data structures created
        
        use sliding window
        
        int stores max profit
        int stores left pointer, right pointer
        while loop iterates until right pointer reaches end of array
            if statement checks left < right
                int stores current profit
                set max profit to the max of current max, current profit
            else left > right
                increment left pointer
            increment right pointer
        return max profit
        */
        
        int maxProfit = 0;
        int left = 0, right = 1;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int currentProfit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, currentProfit);
            }
            else {
                left = right;
            }
            right++;
        }
        return maxProfit;
        
        /* Tests
        [1,2,3] -> right 1 < length 3, price 1 < price 2, currentProfit = 2 - 1 = 1,
        maxProfit = 1, right = 2; right 2 < length 3, price 1 < price 3,
        currentProfit = 3 - 1 = 2, maxProfit = 2, right = 3; right 3 == length 3;
        -> return 2
        
        [3,2,1] -> right 1 < length 3, price 3 > price 2, left = 1, right = 2;
        right 2 < length 3, price 2 > price 1, left = 2, right = 3; right 3 == length 3;
        -> return 0
        */
        
        /* Optimize
        O(n) runtime, iterates through single while loop based on given array length
        O(1) space, no additional data structures created
        */
    }
}