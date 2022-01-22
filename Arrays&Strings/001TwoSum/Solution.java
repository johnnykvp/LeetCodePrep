class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* Notes
        Find the 2 nums that add up to the target, & return their indicies
        */
        
        /* Questions
        Can there be duplicate values in the given array? (Yes)
        Is the given array sorted? (No, nay be in any order)
        */
        
        /* Approach
        int array to store indicies that sum to target
        for loop iterates through array ints
            nested for loop iterates through next index
                if statement checks current indicies == target
                    set array index values to current indicies
        return array indicies
        */
        
        /*
        int[] indicies = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    indicies[0] = i;
                    indicies[1] = j;
                }
            }
        }
        return indicies;
        */
        
        /* Tests
        [3,2,4], target = 6 -> i = 0, j = 1, 3 + 2 = 5 != 6; j = 2, 3 + 4 = 7 != 6; i = 1,
        j = 2, 2 + 4 = 6 == 6, indicies[0] = 1, indicies[1] = 2 -> return [1,2]
        */
        
        /* Optimize
        O(n^2) runtime, iterates through nested loop based on given array length
        O(n) space, created array data structure
        
        map stores num, index
        for loop iterates through array nums
            if statement checks map contains target - current index num
                return array index values of target - current num, current num
            add num, index to map
        return null
        */
        
        Map<Integer, Integer> indicies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indicies.containsKey(target - nums[i])) {
                return new int[] {indicies.get(target - nums[i]), i};
            }
            indicies.put(nums[i], i);
        }
        return null;
        
        /* Tests
        [3,2,4], target = 6 -> i = 0, indicies = [(3,0)]; i = 1, 6 - 2 = 4, !contains 4,
        indicies = [(3,0),(2,1)]; i = 2, 6 - 4 = 2, contains 2 -> return [1,2]
        
        [3,3], target = 6 -> i = 0, indicies = [(3,0)]; i = 1, 6 - 3 = 3, contains 3
        -> return [0,1]
        */
        
        /* Optimize
        O(n) runtime, iterates through single for loop based on given array length
        O(n) space, created map to store nums, indicies from given array
        */
    }
}