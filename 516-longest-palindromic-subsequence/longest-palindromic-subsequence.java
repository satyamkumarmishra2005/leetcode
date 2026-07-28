class Solution {
    public int longestPalindromeSubseq(String s) {

        String reverse = new StringBuilder(s).reverse().toString();

        int n = s.length();
        int m = reverse.length();

        int[][] dp = new int[n][m];


        for(int[]row: dp){
            Arrays.fill(row,-1);
        }
        return solve(s,reverse,dp,n-1,m-1);
    }

    public int solve(String s, String reverse, int[][]dp , int indx1, int indx2){

        if(indx1<0 || indx2<0){
            return 0;
        }

        if(dp[indx1][indx2]!=-1){
            return dp[indx1][indx2];
        }

        if(s.charAt(indx1)==reverse.charAt(indx2)){
         return dp[indx1][indx2] = 1+ solve(s,reverse,dp,indx1-1,indx2-1);
        }

        return dp[indx1][indx2] = Math.max(solve(s,reverse,dp,indx1-1,indx2), solve(s,reverse,dp,indx1,indx2-1));
    }
}