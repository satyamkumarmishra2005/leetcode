

// Solution Class
class Solution {
  // Method to find the repeated sequences in the string
  public List<String> findRepeatedDnaSequences(String s) {
    // Convert the string into the character array
    char[] str = s.toCharArray();

    // Initialize the hash map for the substrings
    HashMap<String, Integer> frequencyMap = new HashMap<>();

    // Initialize the string builder for the string formation
    StringBuilder sb = new StringBuilder();

    // Make the stings of the size of 10
    for (int i = 0; i < str.length; i++) {
      // Append the current character to the string builder
      sb.append(str[i]);

      // If string builder length is 11 then remove the first character
      if (sb.length() == 11) {
        sb.deleteCharAt(0);
      }

      // If string builder length is 10 then add it to the hash map
      if (sb.length() == 10) {
        // Get the key form the string builder
        String key = sb.toString();

        // Update the hash map
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
      }
    }

    // Initialize the Array list for result
    ArrayList<String> result = new ArrayList<>();

    // If hash map frequency is more then 1 then add it to the result
    for (HashMap.Entry<String, Integer> val : frequencyMap.entrySet()) {
      // If value of is more than 1 then add the key to the result
      if (val.getValue() > 1) {
        result.add(val.getKey());
      }
    }

    // Return the result
    return result;
  }
}

public class _187_Repeated_DNA_Sequences {
  // Main method to test findRepeatedDnaSequences
  public static void main(String[] args) {
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

    List<String> result = new Solution().findRepeatedDnaSequences(s);

    System.out.println("The repeated sequences in the string is : " + result);
  }
}