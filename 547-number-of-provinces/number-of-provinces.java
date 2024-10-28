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


void dfs(int [][] isConnected , boolean visited[] , int i){
     visited[i] = true;

     for(int j =0 ; j< n ; j++){

        if(!visited[j] && isConnected[i][j] == 1 ) dfs(isConnected , visited , j);
     }
}

}