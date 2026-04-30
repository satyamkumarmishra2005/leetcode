class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if (n == 1) return 1;
        if (n == 2) return 2;

        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }

        int k = 0;
        while ((1 << k) <= max) {
            k++;
        }

        return 1 << k;
    }
}