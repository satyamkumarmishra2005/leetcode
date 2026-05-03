class Solution {
    public int minFlips(int a, int b, int c) {
        int res = (a | b) ^ c;
        return Integer.bitCount(res) + Integer.bitCount((a & b) & res);
    }
}