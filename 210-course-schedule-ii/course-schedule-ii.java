class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        
  List<Integer>[] adj = new List[n];
        int[] indegree = new int[n];
        List<Integer> res = new ArrayList<>();

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
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            if (adj[node] != null) {
                for (int next : adj[node]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

       if (res.size() != n) {
    return new int[0];
}

        int ans [] = new int [n];
        for(int i =0 ; i< n ; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}