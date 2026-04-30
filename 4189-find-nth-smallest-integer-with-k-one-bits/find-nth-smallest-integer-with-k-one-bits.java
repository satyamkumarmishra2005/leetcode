class Solution {

    // nCr
    long comb(int n, int r) {
        if (r > n || r < 0) return 0;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
        }
        return res;
    }

    public long nthSmallest(long n, int k) {

        int len = 1;

        // find length
        while (true) {
            long count = comb(len - 1, k - 1);
            if (n > count) {
                n -= count;
                len++;
            } else break;
        }

        long res = 1L << (len - 1);
        int remaining = k - 1;

        for (int pos = len - 2; pos >= 0; pos--) {

            long count = comb(pos, remaining);

            if (n > count) {
                res |= (1L << pos);
                n -= count;
                remaining--;
            }
        }

        return res;
    }
}