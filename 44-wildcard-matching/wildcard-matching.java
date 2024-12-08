 class Solution {
//     public int isMatch(String S1, String S2) {
//           int n = S1.length();
//     int m = S2.length();

//     int dp[][] = new int[n][m];
//     for (int row[]: dp)
//       Arrays.fill(row, -1);

//     // Call the recursive helper function
//     return wildcardMatchingUtil(S1, S2, n - 1, m - 1, dp);
//   }

//  static int wildcardMatchingUtil(String S1, String S2, int i, int j, int[][] dp) {
//     // Base Cases
//     if (i < 0 && j < 0)
//       return 1; // Both strings are empty, and the pattern matches.
//     if (i < 0 && j >= 0)
//       return 0; // S1 is empty, but there are characters left in S2.
//     if (j < 0 && i >= 0)
//       return isAllStars(S1, i) ? 1 : 0; // S2 is empty, check if remaining characters in S1 are all '*'.

//     // If the result is already computed, return it.
//     if (dp[i][j] != -1) return dp[i][j];

//     // If the characters match or S1 has a '?', continue matching the rest of the strings.
//     if (S1.charAt(i) == S2.charAt(j) || S1.charAt(i) == '?')
//       return dp[i][j] = wildcardMatchingUtil(S1, S2, i - 1, j - 1, dp);

//     else {
//       if (S1.charAt(i) == '*') {
//         // Two possibilities when encountering '*':
//         // 1. '*' matches one or more characters in S2.
//         // 2. '*' matches zero characters in S2.
//         return dp[i][j] = (wildcardMatchingUtil(S1, S2, i - 1, j, dp) == 1 || wildcardMatchingUtil(S1, S2, i, j - 1, dp) == 1) ? 1 : 0;
//       } else {
//         // Characters don't match, and S1[i] is not '*'.
//         return 0;
//       }
//     }
//   }

//  static boolean isAllStars(String S1, int i) {
//     for (int j = 0; j <= i; j++) {
//       if (S1.charAt(j) != '*')
//         return false;
//     }
//     return true;
//   }
//     }
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