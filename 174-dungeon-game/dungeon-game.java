class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;

        int n = dungeon[0].length;


        int[][] dp = new int[m][n];


        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }



        return solve(dungeon, dp, 0,0, m , n);
        
    }


    public int solve(int[][]dungeon, int[][]dp , int i , int j , int m , int n){


        if(i>= m || j>= n){

          return (int)1e9;
            
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        if(i==m-1 && j==n-1){
            return dp[i][j] = (dungeon[i][j]>0 ? 1: Math.abs(dungeon[i][j])+1);
        }


        int down = solve(dungeon, dp, i+1, j , m , n);

        int right = solve(dungeon, dp, i, j+1, m,n);


        int result = Math.min(down,right)- dungeon[i][j];

        return dp[i][j] =( result>0? result: 1);
    }
}