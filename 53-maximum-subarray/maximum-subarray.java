class Solution {

    public int maxSubArray(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    private int divide(int[] nums, int left, int right) {

        // base case
        if (left == right) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        // solve left and right
        int leftMax = divide(nums, left, mid);
        int rightMax = divide(nums, mid + 1, right);

        // solve crossing
        int crossMax = maxCrossing(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private int maxCrossing(int[] nums, int left, int mid, int right) {

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        // go left from mid
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        // go right from mid+1
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }
}