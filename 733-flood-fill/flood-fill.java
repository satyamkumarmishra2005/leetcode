class Solution {


    int rows;
    int cols;

    // void dfs(int row , int col , int newcolor , int currcolor ,  int[][] image){
    //     // out of bound cases  and colour are not same
    //     if(row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != currcolor|| image[row][col]== newcolor ){
    //         return;
    //     }

    //     image[row][col] = newcolor;
      
    //     // visit neighbours 
    //     // up , down , left , right
    //     int adjList[][] = {{row-1 , col}, {row+1 , col}, {row , col-1}, {row , col+1}};

    //     for(int [] neighbour : adjList){
    //         dfs(neighbour[0],neighbour[1], newcolor , currcolor ,  image);
    //     }

    // }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // rows = image.length;
        // cols = image[0].length;
       
        //  dfs(sr,sc, color , image[sr][sc]  , image);
        //  return image;


        rows = image.length;
        cols = image[0].length;

        Queue<int [] > queue = new LinkedList<>();
        int currcolor = image[sr][sc];
        queue.offer(new int[]{sr,sc}); // inserted source node and col
        image[sr][sc] = color ; // fill,visit
         while(!queue.isEmpty()){
            int node[] = queue.poll();
            int row = node[0];
            int col = node[1];

            int adjList[][] = {{row-1,col},{row+1,col},{row,col-1},{row,col+1}};

            for(int[] neighbour : adjList){
                int r = neighbour[0];
                int c = neighbour[1];
                 if(r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != currcolor|| image[r][c]== color ){
                    continue;
                 }
                 queue.offer(new int[]{r,c});
                 image[r][c] = color;
            }
         }
         return image;
    }
}