import java.util.*;

class Solution {
    public int minCost(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        boolean[][][] vis = new boolean[m][n][1024];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, grid[0][0]});
        vis[0][0][grid[0][0]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], x = cur[2];

            // right
            if (j + 1 < n) {
                int nx = x ^ grid[i][j + 1];
                if (!vis[i][j + 1][nx]) {
                    vis[i][j + 1][nx] = true;
                    q.offer(new int[]{i, j + 1, nx});
                }
            }

            // down
            if (i + 1 < m) {
                int nx = x ^ grid[i + 1][j];
                if (!vis[i + 1][j][nx]) {
                    vis[i + 1][j][nx] = true;
                    q.offer(new int[]{i + 1, j, nx});
                }
            }
        }

        // find minimum XOR at destination
        for (int x = 0; x < 1024; x++) {
            if (vis[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}