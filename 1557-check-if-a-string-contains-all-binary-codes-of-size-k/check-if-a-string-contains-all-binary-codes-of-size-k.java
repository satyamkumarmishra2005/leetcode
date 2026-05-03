

// Solution Class
class Solution {
  public boolean hasAllCodes(String s, int k) {
    int totalNumbersOfCodes = (1 << k);

    char[] binary = s.toCharArray();

    if (binary.length < totalNumbersOfCodes) {
      return false;
    }

    boolean[] codes = new boolean[totalNumbersOfCodes];

    int totalCodes = 0, current = 0;

    for (int i = 0; i < binary.length; i++) {
      current = ((current << 1) & ((1 << k) - 1)) | (binary[i] - '0');

      if (i >= k - 1 && !codes[current]) {
        totalCodes++;
        codes[current] = true;
      }
    }

    return totalCodes == totalNumbersOfCodes;
  }
}

public class _1461_Check_If_a_String_Contains_All_Binary_Codes_of_Size_K {
  public static void main(String[] args) {
    String s = "00110110";
    int k = 2;

    boolean result = new Solution().hasAllCodes(s, k);

    System.out.println("The string " + s + (result ? " " : " does not ")
        + "contains all codes of length " + k + ".");
  }
}