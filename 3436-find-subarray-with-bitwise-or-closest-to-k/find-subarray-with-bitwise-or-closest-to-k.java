import java.util.*;

class Solution {
    public int minimumDifference(int[] nums, int k) {

        Set<Integer> curr = new HashSet<>();
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {

            Set<Integer> next = new HashSet<>();
            next.add(num);

            for (int val : curr) {
                next.add(val | num);
            }

            curr = next;

            for (int val : curr) {
                ans = Math.min(ans, Math.abs(val - k));
            }
        }

        return ans;
    }
}