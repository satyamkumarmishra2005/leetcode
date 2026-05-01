class Solution {

    public int maxMoves(int kx, int ky, int[][] positions) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            map.put(List.of(positions[i][0], positions[i][1]), i);
        }
        int[][] d = new int[positions.length + 1][positions.length + 1];
        maxMoves(List.of(kx, ky), map, d[positions.length]);
        for (int i = 0; i < positions.length; i++) {
            maxMoves(List.of(positions[i][0], positions[i][1]), map, d[i]);
        }
        return maxMoves(positions.length, 0, d, true, new int[positions.length + 1][1 << positions.length]);
    }

    private void maxMoves(List<Integer> list, HashMap<List<Integer>, Integer> map, int[] d) {
        ArrayDeque<List<Integer>> deque = new ArrayDeque<>(List.of(list));
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0, c = d.length; c > 1; i++) {
            for (int j = deque.size(); j > 0; j--) {
                List<Integer> poll = deque.poll();
                if (!set.contains(poll)) {
                    set.add(poll);
                    if (map.containsKey(poll)) {
                        d[map.get(poll)] = i;
                        c--;
                    }
                    if (poll.get(0) >= 0 && poll.get(0) < 50 && poll.get(1) >= 0 && poll.get(1) < 50) {
                        for (int[] k : new int[][] { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } }) {
                            deque.offer(List.of(poll.get(0) + k[0], poll.get(1) + k[1]));
                        }
                    }
                }
            }
        }
    }

    private int maxMoves(int k, int curr, int[][] d, boolean flag, int[][] dp) {
        if (curr + 1 == 1 << d.length - 1) {
            return 0;
        } else if (dp[k][curr] == 0) {
            dp[k][curr] = flag ? 0 : Integer.MAX_VALUE;
            for (int i = 0; i < d.length - 1; i++) {
                if ((1 << i & curr) == 0) {
                    int next = maxMoves(i, 1 << i | curr, d, !flag, dp) + d[k][i];
                    dp[k][curr] = flag ? Math.max(dp[k][curr], next) : Math.min(dp[k][curr], next);
                }
            }
        }
        return dp[k][curr];
    }
}