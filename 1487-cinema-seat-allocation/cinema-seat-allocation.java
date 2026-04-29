class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: build row masks
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row, map.getOrDefault(row, 0) | (1 << (col - 1)));
        }

        int result = 0;

        // Masks for blocks
        int leftMask   = 0b0000011110; // seats 2-5
        int middleMask = 0b0001111000; // seats 4-7
        int rightMask  = 0b0111100000; // seats 6-9

        // Step 2: process reserved rows
        for (int mask : map.values()) {
            boolean leftFree   = (mask & leftMask) == 0;
            boolean rightFree  = (mask & rightMask) == 0;
            boolean middleFree = (mask & middleMask) == 0;

            if (leftFree && rightFree) {
                result += 2;
            } else if (leftFree || rightFree || middleFree) {
                result += 1;
            }
        }

        // Step 3: rows with no reservations
        result += (n - map.size()) * 2;

        return result;
    }
}