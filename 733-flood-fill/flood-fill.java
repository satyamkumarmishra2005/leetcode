class Solution {
    int rows;
    int cols;

    void dfs(int row , int col , int newcolor , int currcolor ,  int[][] image){
        // out of bound cases and visited and colour are not same
        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != currcolor|| image[row][col]== newcolor ){
            return;
        }

        image[row][col] = newcolor;
      
        // visit neighbours 
        // up , down , left , right
        int adjList[][] = {{row-1 , col}, {row+1 , col}, {row , col-1}, {row , col+1}};

        for(int [] neighbour : adjList){
            dfs(neighbour[0],neighbour[1], newcolor , currcolor ,  image);
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
       
         dfs(sr,sc, color , image[sr][sc]  , image);
         return image;
    }
}