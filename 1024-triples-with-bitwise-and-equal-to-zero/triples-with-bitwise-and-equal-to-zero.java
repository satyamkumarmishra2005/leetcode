class Solution {
    public int countTriplets(int[] nums) {
        int max = 1 << 16;
        int[] count = new int[max];

        // Step 1: count all pair ANDs
        for (int a : nums) {
            for (int b : nums) {
                count[a & b]++;
            }
        }

        int result = 0;

        // Step 2: check with third element
        for (int c : nums) {
            for (int x = 0; x < max; x++) {
                if ((x & c) == 0) {
                    result += count[x];
                }
            }
        }

        return result;
    }
}