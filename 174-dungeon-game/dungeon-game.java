class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;

        int n = dungeon[0].length;


        int [][] dp = new int[m][n];

        for(int[] rows: dp){
            Arrays.fill(rows, -1);
        }


        return solve(dungeon , dp , 0, 0, m , n);
        
    }


   public int solve( int[][] dungeon , int[][]t, int i, int j, int m , int n) {
        if (i >= m || j >= n)
            return (int)1e9;

        if (t[i][j] != -1)
            return t[i][j];

        if (i == m - 1 && j == n - 1)
            return t[i][j] = (dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1);

        int down  = solve( dungeon, t, i + 1, j,m,n);
        int right = solve( dungeon, t, i, j + 1,m,n);

        int res = Math.min(down, right) - dungeon[i][j];
        return t[i][j] = (res > 0 ? res : 1);
    }
}