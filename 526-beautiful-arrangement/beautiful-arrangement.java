class Solution {
    // Stores total count of beautiful arrangements
    int cnt = 0;

    // Tracks which numbers are already used
    boolean[] visited;

    public int countArrangement(int n) {
        // visited[i] tells whether number i is already used
        visited = new boolean[n + 1];

        // Start backtracking with an empty permutation
        fun(n, new ArrayList<>());

        return cnt;
    }

    private void fun(int n, List<Integer> list) {
        // Base case: if we placed n numbers, it's a valid arrangement
        if (list.size() == n) {
            cnt++;
            return;
        }

        // Current position (1-indexed)
        int pos = list.size() + 1;

        // Try placing every number from 1 to n
        for (int i = 1; i <= n; i++) {

            // Skip if number is already used
            if (visited[i])
                continue;

            // Check beautiful arrangement condition
            if (i % pos == 0 || pos % i == 0) {

                // Choose
                visited[i] = true;
                list.add(i);

                // Explore
                fun(n, list);

                // Un-choose (backtracking)
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}