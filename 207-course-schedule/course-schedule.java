class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
       // List<Integer> ans = new ArrayList<>();
       int count = 0;

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null) {
                adj[prerequisite] = new ArrayList<>();
            }
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count ++;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
         //   ans.add(node);

            if (adj[node] != null) {
                for (int next : adj[node]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        count ++;
                        queue.offer(next);
                    }
                }
            }
        }

        return count == n; // return true;
    }
}