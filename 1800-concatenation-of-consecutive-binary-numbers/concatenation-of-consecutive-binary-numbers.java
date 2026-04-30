class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int mod = 1_000_000_007;
        int len = 0;

        for (int i = 1; i <= n; i++) {
            
            // if power of 2 → increase bit length
            if ((i & (i - 1)) == 0) {
                len++;
            }

            res = ((res << len) | i) % mod;
        }

        return (int) res;
    }
}