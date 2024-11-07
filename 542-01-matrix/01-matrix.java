class Solution {
    int m ;
    int n ;

    // we are performing BFS from 0 to all 1

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};  // Directions in which we can move {upward , Downward , left , right}

    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        n = mat[0].length;

        Queue<int [] > queue = new LinkedList<>();
        int [][] res = new int [m][n];

          // Initialize the queue with all 0 cells and mark 1 cells as unvisited (-1)

        for(int i =0 ; i< m ; i++){
            for(int j =0 ; j< n ; j++){
                if(mat[i][j] == 0){
                    res[i][j] =0;  // Distance of 0 cells from themselves is 0
                    queue.offer(new int [] {i,j});  // Add all 0 cells to the queue
                }

                else{
                    res[i][j] = -1;  // Mark all 1 cells as unvisited
                }

            }
        }

         // Perform BFS starting from all 0 cells

        while(!queue.isEmpty()){
            int [] cell = queue.poll();

            int i = cell[0];
            int j = cell[1];

            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                //new_i = i + dir[0] = 1 + (-1) = 0 (moves up to row 0).
              //  new_j = j + dir[1] = 1 + 0 = 1 (column stays the same).
               // This gives (new_i, new_j) = (0, 1), which is the cell above (1, 1). 

                  // Check bounds and if the neighbor has been visited

                if(new_i  >= 0 && new_i < m && new_j >=0 && new_j < n && res[new_i][new_j] == -1){
                    res[new_i][new_j] = res[i][j] + 1;  // Set distance for the neighbor

                    queue.add(new int [] {new_i , new_j});
                }
            }


        }

        return res;
        
    }
}