class Solution {
    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        boolean [][] visited = new boolean[rows][cols];



        for(int row =0; row<rows; row++){

            for(int col=0; col<cols; col++){


                if(board[row][col]== word.charAt(0)){

                    if(dfs(board, word ,visited, 0,row , col )){
                        return true;
                    }
                }
            }
        }

        return false;

        
    }


    public boolean dfs(char[][]board, String  word, boolean[][] visited , int index , int row, int col){

        if(index==word.length()){
            return true;
        }


        if(row<0 || row>=board.length || col<0 || col>= board[0].length ){
            return false;
        }

       if(visited[row][col]){
        return false;
       }

       if(board[row][col]!= word.charAt(index)){
        return false;
       }


       visited[row][col] = true;


       boolean found = dfs(board , word, visited, index+1, row-1, col) ||

       dfs(board,word,visited, index+1, row+1, col)   ||

       dfs(board, word, visited , index+1, row,col-1)  ||

       dfs(board, word, visited, index+1, row, col+1);


         // Backtrack
        visited[row][col] = false;



       return found;
    
    }
}