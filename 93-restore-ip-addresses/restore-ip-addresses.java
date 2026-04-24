import java.util.*;

class Solution {
    int n;
    List<String> result = new ArrayList<>();

    public boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return str.length() == 1; // allow "0" but not "01", "00"
        }

        int val = Integer.parseInt(str);
        return val <= 255;
    }

    public void solve(String s, int idx, int part, String curr) {
        if (idx == n && part == 4) {
            result.add(curr.substring(0, curr.length() - 1)); // remove last '.'
            return;
        }

        if (idx >= n || part >= 4) return;

        // take 1 digit
        if (idx + 1 <= n) {
            solve(s, idx + 1, part + 1, curr + s.substring(idx, idx + 1) + ".");
        }

        // take 2 digits
        if (idx + 2 <= n && isValid(s.substring(idx, idx + 2))) {
            solve(s, idx + 2, part + 1, curr + s.substring(idx, idx + 2) + ".");
        }

        // take 3 digits
        if (idx + 3 <= n && isValid(s.substring(idx, idx + 3))) {
            solve(s, idx + 3, part + 1, curr + s.substring(idx, idx + 3) + ".");
        }
    }

    public List<String> restoreIpAddresses(String s) {
        result.clear();
        n = s.length();

        if (n > 12) return result;

        solve(s, 0, 0, "");
        return result;
    }
}