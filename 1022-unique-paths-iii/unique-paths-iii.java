class Solution {

    int path =0;
    public int uniquePathsIII(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int emptycells = 0;
        int startrow =0;
        int startcol=0;

        for(int row =0; row< rows ; row++){

            for(int col=0; col< cols ; col++){
                
                if(grid[row][col]!= -1){
                  emptycells++;
                }

                if(grid[row][col]==1){
                   startrow=row;
                   startcol=col;
                }
            }
        }


        dfs(grid , startrow, startcol , emptycells );

        return path;
        
    }

    public void dfs(int[][] grid , int row , int col , int remaining){

          // Out of bounds
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {
            return;
        }

          // Obstacle or already visited
        if (grid[row][col] == -1) {
            return;
        }


        if(grid[row][col]==2){

            if(remaining==1){
                path++;
            }

            return;
        }


        int temp = grid[row][col];

        grid[row][col]= -1; // visited mark


         dfs(grid, row - 1, col, remaining - 1);
        dfs(grid, row + 1, col, remaining - 1);
        dfs(grid, row, col - 1, remaining - 1);
        dfs(grid, row, col + 1, remaining - 1);
        

        // Backtrack
        grid[row][col] = temp;


    }
}