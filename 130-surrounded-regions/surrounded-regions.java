class Solution {

  //  The intuition is that we start from boundary elements having ‘O’ and go through its neighboring Os in 4 directions and mark them as visited to avoid replacing them with ‘X’. 

  // start form the boundary o and mark them visited as they can not be converted
  // if any O is connected to the boundary O then mark them also visisted by dfs

  // and convert the other O to X 
    int m ;
    int n ;
    public void solve(char[][] board) {
         int[] delrow= {-1,0,+1,0};
        int[] delcol= {0,+1,0,-1};
        m = board.length;
        n = board[0].length;
        boolean [][] visited = new boolean [m][n];

        for(int i =0 ; i< m ; i++){
            // visiting first col 
            if(!visited[i][0] && board[i][0] == 'O'){
                dfs(i,0 , delrow , delcol , visited , board);
            }

            // visiting last col

            if(!visited[i][n-1] && board[i][n-1] == 'O'){
                dfs(i , n-1 , delrow , delcol , visited , board);
            }


        }

        for(int i =0 ; i< n ; i++){
            // first row 
            if(!visited[0][i] && board[0][i] == 'O'){
                dfs(0 , i , delrow , delcol , visited , board);
            }
            // last row

            if(!visited[m-1][i] && board[m-1][i] == 'O'){
                dfs(m-1 , i , delrow , delcol , visited , board);
            }
        }

        // Mark the unvisited '0' as 'X' that will be only  in between bcz all the corner 'O' which 'O ' which are attached with other O are already marked as true viu dfs

    for(int i =0 ; i< m ; i++){
    for(int j =0 ; j< n ; j++){
        if(!visited[i][j] && board[i][j] == 'O'){
            board[i][j] = 'X';
        }
    }
    }


        
    }

    public void dfs(int row , int col , int [] delrow , int [] delcol , boolean[][] visited , char [][] board){
        visited[row][col] = true; 
        int m = board.length;
        int n = board[0].length;

        for(int i =0 ; i< 4 ; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow>=0 && nrow < m && ncol >=0 && ncol < n && !visited[nrow][ncol] && board[nrow][ncol]== 'O'){
                  dfs(nrow, ncol, delrow, delcol, visited, board); // passing the neighbours i.r all 4 direction of curr cell to the DFS if it statisfies the condition so it will be marked true as soon as recc calls DFS
            }
        }

    }


}