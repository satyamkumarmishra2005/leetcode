class Solution{
public boolean isMatch(String s, String p) {
    int n = s.length();
    int m = p.length();

    int dp[][] = new int[n + 1][m + 1];
    for (int row[] : dp)
        Arrays.fill(row, -1);

    // Call the recursive helper function
    return wildcardMatchingUtil(s, p, n, m, dp) == 1; // Convert result to boolean
}

static int wildcardMatchingUtil(String s, String p, int i, int j, int[][] dp) {
    // Base Cases
    if (i == 0 && j == 0)
        return 1; // Both strings are empty, and the pattern matches.
    if (j == 0)
        return 0; // Pattern is empty, but s is not empty.
    if (i == 0)
        return isAllStars(p, j) ? 1 : 0; // Check if remaining characters in the pattern are all '*'.

    // If the result is already computed, return it.
    if (dp[i][j] != -1)
        return dp[i][j];

    // If the characters match or pattern has '?', match one character.
    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
        return dp[i][j] = wildcardMatchingUtil(s, p, i - 1, j - 1, dp);
    } else if (p.charAt(j - 1) == '*') {
        // Two possibilities when encountering '*':
        // 1. '*' matches one or more characters in s: reduce `i`.
        // 2. '*' matches zero characters in s: reduce `j`.
        return dp[i][j] = (wildcardMatchingUtil(s, p, i - 1, j, dp) == 1 || wildcardMatchingUtil(s, p, i, j - 1, dp) == 1) ? 1 : 0;
    } else {
        return dp[i][j] = 0; // Characters don't match, and it's not a wildcard.
    }
}

static boolean isAllStars(String p, int j) {
    for (int idx = 0; idx < j; idx++) {
        if (p.charAt(idx) != '*')
            return false;
    }
    return true;
}


 }
