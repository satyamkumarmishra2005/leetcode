class Solution {
    public int maxXorSubsequences(int[] nums) {

        int[] basis = new int[32];

        // build linear basis
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if (((num >> i) & 1) == 0) continue;

                if (basis[i] == 0) {
                    basis[i] = num;
                    break;
                }

                num ^= basis[i];
            }
        }

        // compute max XOR
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            res = Math.max(res, res ^ basis[i]);
        }

        return res;
    }
}