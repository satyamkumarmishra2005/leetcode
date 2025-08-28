class Solution {
    public double myPow(double x, int n) {
        return power(x, (long) n); // cast to long once
    }

    private double power(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Handle negative exponent
        if (n < 0) {
            return 1 / power(x, -n);
        }

        // Fast exponentiation
        double half = power(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
