// class Solution {
//     public int orangesRotting(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//          int freshcount = 0;

//         Queue<int [] > queue = new LinkedList<>();

        
       
//          for(int i = 0 ; i< n ; i++ ){
//             for(int j =0 ; j< m ; j++){
//               if(grid[i][j]==1){
//                 freshcount ++;
//               }
//               else if(grid[i][j]==2){
//                 queue.offer(new int [] {i,j});
//               }
//             }
//          }
//          if(freshcount==0){
//             return 0;
//          }
//          int time = 0;

//          while(!queue.isEmpty()){
//             // Levl by Level
//             int size = queue.size();
//             for(int i =0 ; i< size ; i++){
//             int rottenloc[] = queue.poll();
//             int r = rottenloc[0];
//             int c = rottenloc[1];
//             int neighbours[][] = { {r-1 , c} , {r , c+1} , {r+1 , c} , {r, c-1} };

//             for(int neighbour[] : neighbours){
//                 int nr = neighbour[0];
//                 int nc = neighbour[1];

//                 // check for outfo bound and alreday visited

//                 if(nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] == 2){
//                     continue; // skip
//                 }
               

//                 queue.offer(new int [] { nr , nc});
//                   grid[nr][nc] = 2 ; // visited
               
//             }
           

//             }
//             time ++;
//             freshcount-= queue.size();

//             if(freshcount==0){
//                 break;
//             }
//          }
//          return (freshcount==0) ? time : -1;
//     }
// }


class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int freshcount = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and add rotten ones to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    freshcount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (freshcount == 0) {
            return 0; // No fresh oranges to rot
        }

        int time = 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotten = false;

            for (int i = 0; i < size; i++) {
                int[] rottenloc = queue.poll();
                int r = rottenloc[0];
                int c = rottenloc[1];

                int[][] neighbours = { {r - 1, c}, {r, c + 1}, {r + 1, c}, {r, c - 1} };

                for (int[] neighbour : neighbours) {
                    int nr = neighbour[0];
                    int nc = neighbour[1];

                    // Check bounds and whether it's a fresh orange
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || grid[nr][nc] != 1) {
                        continue;
                    }

                    // Mark as rotten and reduce fresh count
                    grid[nr][nc] = 2;
                    freshcount--;
                    queue.offer(new int[] { nr, nc });
                    rotten = true;
                }
            }

            // Increment time only if some fresh oranges were rotted in this level
            if (rotten) {
                time++;
            }

            // Break if no fresh oranges are left
            if (freshcount == 0) {
                return time;
            }
        }

        return -1; // Some fresh oranges couldn't be rotted
    }
}


