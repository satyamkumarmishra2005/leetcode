class Solution {

      public int dfs(int src , int parent , List<List<Integer>> adjList ,List<Boolean> hasApple ){
            int totalTime = 0;
            for(int neighbour : adjList.get(src)){
                if(neighbour == parent){
                    continue;
                }

                int timetakenBychild = dfs(neighbour , src , adjList , hasApple);

                if(timetakenBychild > 0 || hasApple.get(neighbour)){ // If the current node has apple or its child has Aplle then calculate the time
                    totalTime += timetakenBychild + 2;
                }
            }
            return totalTime;

        }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

      
        // Create an Adj list 
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i =0 ; i< n ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int [] edge : edges){
            int  from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);




        }

        return dfs(0 , -1 , adjList , hasApple);
    }
}