class Solution {

    // in this we have to find the number of componenets 
    // The no of times Dfs call is made  is equal to number of components
    int n ;
    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;

        boolean [] visited = new boolean[n];
        int count = 0;

        for(int i =0 ; i< n ; i++){

            if(!visited[i]){
                dfs(i , isConnected, visited);
                count ++;
            }

        }

        return count;
        
    }

    void dfs(int u ,int[][] isConnected ,  boolean [] visited  ){
        visited[u] = true;

        for(int v = 0 ; v< n ; v++){

            if(!visited[v] && isConnected[u][v]==1){  // v is not visisted and v is the neighbour of u then aplly dfs
                dfs(v , isConnected , visited);
            }
        }
    }
}