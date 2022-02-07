class Solution {
    public int maxSubArray(int[] nums) {
        /* Questions
        Contiguous meaning continuous segment of an arrqy? (Yes)
        Are the numbers sorted? (No, may be in any order)
        */
        
        /* Approach
        int stores max sum
        int stores current sum
        for loop iterates through array nums
            if statement checks current index value > current sum + current index value
                set current sum = current index value
            else
                increment current sum by current index value
            if statement checks current sum > max sum
                set max sum = current sum
        return max sum
        */
        
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                currentSum = nums[i];
            }
            else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
        
        /* Tests
        [5,4,-1,7,8] -> i = 0, 5 == 0 + 5, currentSum = 5, 5 > int min, maxSum = 5; i = 1,
        4 < 5 + 4, currentSum = 9, 9 > 5, maxSum = 9; i = 2, -1 < 9 - 1, currentSum = 8,
        8 < 9; i = 3, 7 < 8 + 7, currentSum = 15, 15 > 9, maxSum = 15; i = 4, 8 < 15 + 8,
        currentSum = 23, 23 > 15, maxSum = 23; -> return 23
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop based on given array length
        O(1) space, no addtional data structures created
        */
    }
}