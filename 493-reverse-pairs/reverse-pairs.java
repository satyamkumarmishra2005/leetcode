class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {

        if (low >= high)
            return 0;

        int mid = low + (high - low) / 2;

        int count = 0;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);

        count += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return count;
    }

    private int countPairs(
            int[] nums,
            int low,
            int mid,
            int high) {

        int count = 0;

        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high &&
                   nums[i] > 2L * nums[right]) {
                right++;
            }

            count += right - (mid + 1);
        }

        return count;
    }

    private void merge(
            int[] nums,
            int low,
            int mid,
            int high) {

        int[] temp =
            new int[high - low + 1];

        int left = low;
        int right = mid + 1;
        int idx = 0;

        while (left <= mid &&
               right <= high) {

            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

        while (right <= high) {
            temp[idx++] = nums[right++];
        }

        for (int i = 0; i < temp.length; i++) {
            nums[low + i] = temp[i];
        }
    }
}