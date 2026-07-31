class Solution {
    public int numDistinct(String s, String t) {

        int n = s.length();
        
        int m = t.length();

        int[][] dp = new int[n][m];

        for(int[]row:dp){
            Arrays.fill(row,-1);
        }



        return solve(s,t,n-1,m-1,dp);


        
    }

    public int solve(String s, String t, int indx1, int indx2, int[][]dp){

        if(indx2<0){
            return 1;
        }

        if(indx1<0){
            return 0;
        }

        if(dp[indx1][indx2]!=-1){
            return dp[indx1][indx2];
        }

        if(s.charAt(indx1)== t.charAt(indx2)){
            return dp[indx1][indx2] = solve(s,t,indx1-1,indx2-1,dp) + solve(s,t,indx1-1, indx2, dp);
        }

        return dp[indx1][indx2] = solve(s,t,indx1-1,indx2,dp);
    }
}