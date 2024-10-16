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

class Pair {
    int row;
    int col;
    int time;

    public Pair(int r, int c, int t) {
        row = r;
        col = c;
        time = t;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();

        // Initialize the queue with all rotten oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    queue.add(new Pair(i, j, 0));
                } 
            }
        }

        int maxTime = 0;

        // Direction vectors for moving up, down, left, and right
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};

        // Process the queue
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int r = p.row;
            int c = p.col;
            int t = p.time;

            // Update the max time
            maxTime = Math.max(maxTime, t);

            // Spread the rot to adjacent fresh oranges
            for (int i = 0; i < 4; i++) {
                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && vis[newRow][newCol] == 0) {
                    vis[newRow][newCol] = 2;
                    queue.add(new Pair(newRow, newCol, t + 1));
                }
            }
        }

        // Check if there's any fresh orange left
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 2) {
                    return -1;
                }
            }
        }

        return maxTime;
    }
}