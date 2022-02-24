class Solution {
    public int removeDuplicates(int[] nums) {
        /* Notes
        given int array
        input sorted in increasing order
        remove the duplicates, so that uniques appear only once
        perform in-place, maintain same order
        return final array index
        */
        
        /* Approach
        sorted set stores unique values
        for loop iterates through array nums
            add num to set
        int stores array pointer
        for loop iterates through set
            replace value at array pointer index
        return array
        */
        
        /* Approach (in-place, O(1) space)
        int counter stores index after removal (starting at 1)
        for loop iterates through array nums
            if statement checks current index != next index
                replace value at counter index with next index
                increment counter
        return counter
        */
        
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[count] = nums[i + 1];
                count++;
            }
        }
        return count;
        
        /* Tests
        [1,1,2] -> i = 0, 1 == 1; i = 1, 1 != 2, nums[1] = 2, count = 2; -> return 2
        
        [0,1,1,1,2,3,3] -> i = 0, 0 != 1, nums[1] = 1, count = 2; i = 1, 1 == 1; i = 2, 1 == 1; i = 3, 1 != 2,
        nums[2] = 2, count = 3; i = 4, 2 != 3, nums[3] = 3, count = 4; i = 5, 3 == 3; -> return 3
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop
        O(1) space, no additional data structures created
        */
    }
}