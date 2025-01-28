import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) { // Handle edge case where array is empty
            return 0;
        }

        int longest = 1; // To store the length of the longest consecutive sequence
        int count = 1; // Count starts at 1 for the current sequence
        int last_smallest = nums[0]; // Initialize to the first element after sorting

        Arrays.sort(nums); // Sort the array to bring consecutive elements together

        for (int i = 1; i < nums.length; i++) { // Start from the second element
            if (nums[i] == nums[i - 1]) { 
                // Ignore duplicates, continue
                continue;
            } else if (nums[i] == nums[i - 1] + 1) { 
                // If the current number is consecutive, increase the count
                count++;
            } else { 
                // Reset the count for a new sequence
                count = 1;
            }

            // Update the longest sequence length
            longest = Math.max(longest, count);
        }

        return longest;
    }
}
