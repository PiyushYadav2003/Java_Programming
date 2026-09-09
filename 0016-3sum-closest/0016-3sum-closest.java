import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Initialize closestSum with the sum of the first three elements
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Step 3: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Update closestSum if the current combination is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                // Adjust pointers based on the comparison with target
                if (currentSum == target) {
                    // Exact match found, can't get closer than a difference of 0
                    return currentSum; 
                } else if (currentSum < target) {
                    // Sum is too small, we need a larger number
                    left++;
                } else {
                    // Sum is too large, we need a smaller number
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}