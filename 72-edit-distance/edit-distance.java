class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for(int[]row:dp){
            Arrays.fill(row,-1);

        }


        return solve(word1,word2,n-1,m-1,dp);


        
    }


    public int solve(String word1, String word2, int indx1, int indx2 , int[][]dp){

        if(indx1<0){
            return indx2+1;
        }

        if(indx2<0){
            return indx1+1;
        }

        if(dp[indx1][indx2]!=-1){
            return dp[indx1][indx2];
        }



        if(word1.charAt(indx1)== word2.charAt(indx2)){
            return dp[indx1][indx2] = solve(word1,word2,indx1-1,indx2-1, dp);
        }

        else{
            return dp[indx1][indx2] = 1 + Math.min(solve(word1, word2, indx1 - 1, indx2 - 1, dp),
                    Math.min(solve(word1, word2, indx1 - 1, indx2, dp), solve(word1, word2, indx1, indx2 - 1, dp)));
        }



    }
}