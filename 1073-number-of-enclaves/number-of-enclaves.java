class Solution {
   int m ;
   int n ;

   void dfs(int [][] grid , int row , int col ){
    if(row  < 0 || row >= m || col<0 || col>= n || grid[row][col]==0 ){
      return ;
    }

    grid[row][col] = 0;
     dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
   }
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        // Apply dfs for first col
        for(int i =0 ; i< m ; i++){
            if(grid[i][0]==1){
                dfs(grid , i , 0);
            }
         // Apply dfs for last col
            if(grid[i][n-1]==1){
                dfs(grid , i , n-1);
            }
        }

        for(int i =0 ; i< n ; i++){
          //  Apply dfs for first row
            if(grid[0][i]== 1){
                dfs(grid , 0 , i);
            }
         // Apply dfs for last row
            if(grid[m-1][i]==1){
                dfs(grid , m-1 , i);
            }
        }

        int count = 0;

        for(int i =0 ; i< m ; i++){
            for(int j =0 ; j< n ; j++){
                if(grid[i][j]==1){
                    count+=1;
                }
            }
        }

        return count;
    }
}