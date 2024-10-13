class Solution {
    int rows;
    int cols;

    void dfs(int row , int col , int newcolor , int currcolor , boolean visited[][] , int[][] image){
        // out of bound cases and visited and colour are not same
        if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != currcolor|| visited[row][col] ){
            return;
        }

        image[row][col] = newcolor;
        visited[row][col] = true;
        // visit neighbours 
        // up , down , left , right
        int adjList[][] = {{row-1 , col}, {row+1 , col}, {row , col-1}, {row , col+1}};

        for(int [] neighbour : adjList){
            dfs(neighbour[0],neighbour[1], newcolor , currcolor , visited , image);
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols]; // false by default
         dfs(sr,sc, color , image[sr][sc] , visited , image);
         return image;
    }
}