import java.util.*;

class Solution {
    public int minRemovals(int[] nums, int target) {

        int n = nums.length;
        int mid = n / 2;

        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, n);

        Map<Integer, Integer> leftMap = build(left);
        Map<Integer, Integer> rightMap = build(right);

        int maxSize = -1;

        for (int x : leftMap.keySet()) {
            int need = target ^ x;

            if (rightMap.containsKey(need)) {
                maxSize = Math.max(maxSize,
                        leftMap.get(x) + rightMap.get(need));
            }
        }

        if (maxSize == -1) return -1;

        return n - maxSize;
    }

    private Map<Integer, Integer> build(int[] arr) {

        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            int xor = 0;
            int size = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    xor ^= arr[i];
                    size++;
                }
            }

            map.put(xor, Math.max(map.getOrDefault(xor, 0), size));
        }

        return map;
    }
}