class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {

        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: build word masks
        for (String word : words) {
            int mask = 0;

            for (char c : word.toCharArray()) {
                mask |= (1 << (c - 'a'));
            }

            // ignore words with >7 unique chars
            if (Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: process puzzles
        for (String puzzle : puzzles) {
            int first = 1 << (puzzle.charAt(0) - 'a');

            int mask = 0;
            for (int i = 1; i < 7; i++) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }

            int sub = mask;
            int count = 0;

            // enumerate all subsets of mask
            while (true) {
                int candidate = sub | first;

                count += freq.getOrDefault(candidate, 0);

                if (sub == 0) break;
                sub = (sub - 1) & mask;
            }

            result.add(count);
        }

        return result;
    }
}