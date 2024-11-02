class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
     ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

     int n = graph.length;

     for(int i =0 ; i< n ; i++){
        adjList.add(new ArrayList<>());
     }

     int indegree[] = new int [n];
     for(int i =0 ; i< n ; i++){
        for(int j =0 ; j< graph[i].length ; j++){
            adjList.get(graph[i][j]).add(i);
            indegree[i]++;
        }
     }

     Queue<Integer> queue = new LinkedList<>();

     for(int i =0 ; i< n ; i++){
        if(indegree[i]==0){
            queue.add(i);
        }
     }


     List<Integer> res = new ArrayList<>();

     while(!queue.isEmpty()){
        int node = queue.poll();
        res.add(node);

        for(int neighbour : adjList.get(node)){

            indegree[neighbour]--;
            if(indegree[neighbour]== 0){
                queue.add(neighbour);
            }

        }

     }

     Collections.sort(res);
     return res;

          
    }
}