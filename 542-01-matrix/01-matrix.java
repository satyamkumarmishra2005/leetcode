class Solution {
    int m ;
    int n ;

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        n = mat[0].length;

        Queue<int [] > queue = new LinkedList<>();
        int [][] res = new int [m][n];

        for(int i =0 ; i< m ; i++){
            for(int j =0 ; j< n ; j++){
                if(mat[i][j] == 0){
                    res[i][j] =0;
                    queue.offer(new int [] {i,j});
                }

                else{
                    res[i][j] = -1;
                }

            }
        }

        while(!queue.isEmpty()){
            int [] cell = queue.poll();

            int i = cell[0];
            int j = cell[1];

            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(new_i  >= 0 && new_i < m && new_j >=0 && new_j < n && res[new_i][new_j] == -1){
                    res[new_i][new_j] = res[i][j] + 1;

                    queue.add(new int [] {new_i , new_j});
                }
            }


        }

        return res;
        
    }
}