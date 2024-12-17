import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    
    // Helper function to compare two strings
    private boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) return false;
        
        int first = 0, second = 0;
        
        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }
        
        return first == s1.length() && second == s2.length();
    }
    
    public int longestStrChain(String[] words) {
        int n = words.length;
        
        // Step 1: Sort words based on their lengths
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        // Step 2: DP array to store the longest chain ending at each index
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        int maxChain = 1;
        
        // Step 3: Compare and update the DP table
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (compare(words[i], words[prev]) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                }
            }
            maxChain = Math.max(maxChain, dp[i]);
        }
        
        return maxChain;
    }
}
