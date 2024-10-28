class Solution {
    int n ;
    public int findCircleNum(int[][] isConnected) {
         n = isConnected.length;
        int count = 0;

        boolean visited [] = new boolean[n];

        for(int i =0 ; i< n ; i++){
            if(!visited[i]){
                count ++;
                dfs( isConnected , visited , i);
            }
        }

        return count;
    }


void dfs(int [][] isConnected , boolean visited[] , int u){
     visited[u] = true;

     for(int v =0 ; v< n ; v++){

        if(!visited[v] && isConnected[u][v] == 1 ) dfs(isConnected , visited , v);
     }
}

}