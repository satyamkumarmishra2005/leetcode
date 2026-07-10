class Solution {

    int [][] directions = {

        {-1,0},// up

        {1,0}, // down

        {0,-1}, // left

        {0,1} // right

    };


    public int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxgold = 0;


        for(int i =0 ; i< rows; i++){

            for(int j =0; j< cols ; j++){

                if(grid[i][j]!=0){

                    maxgold = Math.max(maxgold, dfs(grid,i,j));

                }
            }
        }

        return maxgold;
        
    }


    public int dfs(int[][] grid , int row , int col){

        if(row<0 || row>= grid.length || col<0 || col>= grid[0].length || grid[row][col]==0){

            return 0;
        }


        int gold = grid[row][col];

        grid[row][col] =0; // mark as visited

        int maxfromneighbours = 0;


        for(int [] dir : directions){

            int newrow = row+ dir[0];
            int newcol = col+ dir[1];


            maxfromneighbours = Math.max(maxfromneighbours , dfs(grid, newrow , newcol));
        }

        grid[row][col] = gold;// backtrack


        return gold + maxfromneighbours;
    }
}