class Solution {

    public int rob(int[] nums) {

        int n = nums.length;

        // Only one house
        if (n == 1) {
            return nums[0];
        }

        int case1 = robLinear(nums, 0, n - 2);

        int case2 = robLinear(nums, 1, n - 1);

        return Math.max(case1, case2);
    }

    private int robLinear(int[] nums, int start, int end) {

        int prev = 0;
        int prev2 = 0;

        for (int i = start; i <= end; i++) {

            int pick = nums[i] + prev2;

            int notPick = prev;

            int curr = Math.max(pick, notPick);

            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
}