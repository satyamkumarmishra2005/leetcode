import java.util.*;

class Solution {

    List<int[]>[] graph;
    int[][] parent;
    int[][] count;
    int[] depth;
    int LOG = 14; // since n <= 10^4

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        parent = new int[n][LOG];
        count = new int[n][27]; // weights 1–26
        depth = new int[n];

        dfs(0, -1);

        // binary lifting preprocess
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                if (parent[i][j - 1] != -1) {
                    parent[i][j] = parent[parent[i][j - 1]][j - 1];
                } else {
                    parent[i][j] = -1;
                }
            }
        }

        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int lca = getLCA(u, v);

            int len = depth[u] + depth[v] - 2 * depth[lca];

            int maxFreq = 0;

            for (int w = 1; w <= 26; w++) {
                int freq = count[u][w] + count[v][w] - 2 * count[lca][w];
                maxFreq = Math.max(maxFreq, freq);
            }

            res[i] = len - maxFreq;
        }

        return res;
    }

    private void dfs(int node, int par) {
        parent[node][0] = par;

        for (int[] nei : graph[node]) {
            int next = nei[0];
            int w = nei[1];

            if (next == par) continue;

            depth[next] = depth[node] + 1;

            // copy parent counts
            for (int i = 1; i <= 26; i++) {
                count[next][i] = count[node][i];
            }

            count[next][w]++;

            dfs(next, node);
        }
    }

    private int getLCA(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        // lift u up
        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != -1 && depth[parent[u][i]] >= depth[v]) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = LOG - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }
}