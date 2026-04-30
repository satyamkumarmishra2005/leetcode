class Solution {
    int maxOr = 0;
    int count = 0;

    public int countMaxOrSubsets(int[] nums) {
        
        // Step 1: compute max OR
        for (int x : nums) {
            maxOr |= x;
        }

        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currOr) {
        
        if (index == nums.length) {
            if (currOr == maxOr) {
                count++;
            }
            return;
        }

        // take
        dfs(nums, index + 1, currOr | nums[index]);

        // skip
        dfs(nums, index + 1, currOr);
    }
}