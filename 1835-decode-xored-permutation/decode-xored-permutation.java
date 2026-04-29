class Solution {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;

        // Step 1: XOR of 1 to n
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }

        // Step 2: XOR of odd indices in encoded
        int oddXor = 0;
        for (int i = 1; i < encoded.length; i += 2) {
            oddXor ^= encoded[i];
        }

        // Step 3: find perm[0]
        int[] perm = new int[n];
        perm[0] = total ^ oddXor;

        // Step 4: reconstruct permutation
        for (int i = 0; i < encoded.length; i++) {
            perm[i + 1] = perm[i] ^ encoded[i];
        }

        return perm;
    }
}