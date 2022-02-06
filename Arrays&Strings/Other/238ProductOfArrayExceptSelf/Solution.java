class Solution {
    public int[] productExceptSelf(int[] nums) {
        /* Notes
        given int array
        return int array so that index i equals product of all elements except num i
        */
        
        /* Questions
        Is the given input array sorted? (No, may be in any order)
        Will we need to deal with values that overflow int max? (No, will fit in 32-bit int)
        */
        
        /* Approach
        int array stores all total products
        for loop iterates through int array
            int stores total product
            nested for loop also iterates through int array
                if statement checks first index equals second index
                    skip index, continue through array
                multiply current index value to total product
            put total product value to array
        return array of total products
        */
        
        /*
        int[] totals = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // Set to 1 so it doesn't affect the total product
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                product = product * nums[j];
            }
            totals[i] = product;
        }
        return totals;
        */
        
        /* Tests
        [1,2,3,4] -> i = 0, j = 0, 0 == 0; j = 1, product = 2; j = 2, product = 6; j = 3,
        product = 24; totals = [24]; i = 1, j = 0, product = 1; j = 1, 1 == 1; j = 2,
        product = 3; j = 3, product = 12; totals = [24,12]; i = 2, j = 0, product = 1;
        j = 1, product = 2; j = 2, 2 == 2; j = 3, product = 8; totals = [24,12,8]; i = 3,
        j = 0, product = 1; j = 1, product = 2; j = 2, product = 6; j = 3, 3 == 3;
        totals = [24,12,8,6] -> return [24,12,8,6]
        */
        
        /* Optimize
        O(n^2) runtime, iterates through nested for loop based on given array size
        O(n) space, created array to store array of products
        
        Find the total product of every value in the array, then divide by the current index
        
        int counter stores num of zeroes
        for loop iterates through array nums
            if statement checks current index value is 0
                increment zero count
                
        if statement checks zero count > 1
            return product results array, all initialized to 0
            
        if statement checks zero count == 1
            int stores product result for index holding 0
            int stores index of zero value
            for loop iterates through given array nums
                if statement checks current index value is 0
                    set zero index
                else
                    multiply value to product result
            set zero index to product result
            return product results array
            
        if statement checks zero count == 0
            int array stores product results
            int stores total product of every num
            for loop iterates through given array nums
                multiply value at current index to total product
            for loop iterates through given array nums
                set result value to product / current index value
            return product results array
        */
        
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
        }
        int[] results = new int[nums.length];
        if (zeroCount > 1) {
            // Java int arrays are initialized to 0 by default
            return results;
        }
        else if (zeroCount == 1) {
            int zeroIndex = 0;
            int product = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    zeroIndex = i;
                }
                else {
                    product = product * nums[i];
                }
            }
            results[zeroIndex] = product;
        }
        else {
            int totalProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                totalProduct = totalProduct * nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                results[i] = totalProduct / nums[i];
            }
        }
        return results;
        
        /* Tests
        [1,2,3,4] -> zeroCount = 0; i = 0, totalProduct = 1; i = 1, totalProduct = 2;
        i = 2, totalProduct = 6; i = 3, totalProduct = 24; i = 0, results[0] = 24; 
        i = 1, results[1] = 12; i = 2, results[2] = 8; i = 3, results[3] = 6;
        -> return [24,12,8,6]
        
        [1,0,2] -> zeroCount = 1; i = 0, product = 1; i = 1, zeroIndex = 1; i = 2, 
        product = 2; results[1] = 2; -> return [0,2,0]
        */
        
        /* Optimize
        O(n) runtime, iterates through separate for loops
        O(n) space, created new array to store product results
        */
    }
}