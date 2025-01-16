class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;

        // Convert the string to a mutable char array
        char[] chars = s.toCharArray();

        // Loop through the string
        while (i < j) {
            // Skip non-vowel characters
            if (!isVowel(chars[i])) {
                i++;
              
            }

           else if (!isVowel(chars[j])) {
                j--;
              
            }

            // Swap vowels
          else{
           swap(chars, i, j);
              i++;
            j--;
        };
    }

        // Convert back to a string and return
        return new String(chars);
    }

    // Method to check if a character is a vowel
    private boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }

    // Method to swap characters in a char array
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
