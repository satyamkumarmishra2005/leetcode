class Solution {
    public void solveSudoku(char[][] board) {

        solve(board);

        
    }

    public boolean solve(char[][] board){

        for(int i =0; i<9; i++){

        for(int j =0; j<9;j++){

            if(board[i][j]=='.'){


                for(char num = '1' ; num<='9'; num++){

                    if(issafe(board, i,j,num)){
                        board[i][j]= num; //choose


                    if(solve(board)){  // explore
                        return true;
                    }
                   

                   board[i][j]= '.'; // backtrack




                    }

                    
                }


                return false;

            }
        }
    }

    return true;

    }


    public boolean issafe(char[][]board, int row , int col , char num){
     

     // check row
        for(int j=0; j<9; j++){

            if(board[row][j]== num){
                return false;
            }
        }


       // check col
        for(int i =0; i<9; i++){

            if(board[i][col]==num){
                return false;
            }
        }


    int start_row = row-row%3;

    int start_col = col-col%3;


    for(int i = start_row ; i<start_row+3; i++){

        for(int j = start_col; j< start_col+3; j++){

            if(board[i][j]==num){
                return false;
            }
        }
    }


    return true;

    }
}