class Solution {
    public boolean containsDuplicate(int[] nums) {
        /* Notes
        take int array, return true if there is any duplicates, false if all unique
        */
        
        /* Questions
        Is the given array sorted? (No, may be in any order)
        */
        
        /* Approach
        set to store unique values
        for loop iterates through num array
            if statement checks set contains num
                return false
        return true
        */
        
        Set<Integer> uniques = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (uniques.contains(nums[i])) {
                return true;
            }
            uniques.add(nums[i]);
        }
        return false;
        
        /* Tests
        [1,2,3,1] -> i = 0, uniques !contain 1, uniques = [1]; i = 1, uniques !contain 2, 
        uniques = [1,2]; i = 2, uniques !contain 3, uniques = [1,2,3]; i = 3,
        uniques contains 1 -> return true
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop based on given array size
        O(n) space, created set to store unique values
        */
    }
}