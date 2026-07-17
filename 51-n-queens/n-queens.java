class Solution {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0; i< n ; i++){
            Arrays.fill(board[i],'.');
        }


        solve(0 , board, ans);


        return ans;
        
    }


    public void solve (int row , char[][] board , List<List<String>> ans){
      
        // All rows processed
        if(row== board.length){
            ans.add(construct(board));
            return;
        }


         // Try placing the queen in every column of this row

         for(int col=0; col<board.length; col++){

            if(issafe(row,col,board)){


             // Choose
                board[row][col]='Q';

            //  Explore next
                solve(row+1,board,ans);
            
            // Backtrack
                board[row][col]='.';
            }
         }
    }




         public boolean issafe(int row , int col , char[][] board){

            int r;
            int c;

            // check the same column upwards

            r= row;

            while(r>=0){

                if(board[r][col]=='Q'){
                    return false;
                }

                r--;

            }

              // Check upper-left diagonal
              r= row;
              c= col;

              while(r>=0 && c>=0){

                if(board[r][c]=='Q'){
                    return false;
                }
                r--;
                c--;

              }


                 // Check upper-right diagonal
                 r= row;
                 c= col;

                 while(r>=0 && c< board.length){

                    if(board[r][c]=='Q'){
                        return false;
                    }
                    r--;
                    c++;
                 }

                 return true;



         }


        // convert the board into List format 
         public List<String> construct(char[][]board){

            List<String> temp = new ArrayList<>();

            for(char[] row: board){

                temp.add(new String(row));
            }

            return temp;
         }






    }