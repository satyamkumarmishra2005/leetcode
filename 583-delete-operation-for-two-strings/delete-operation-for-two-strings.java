class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for(int[]row: dp){
            Arrays.fill(row,-1);
        }

        int k = solve(word1 , word2,n-1,m-1,dp);

        return (n-k) + (m-k);


    }

 public int solve(String text1, String text2, int indx1, int indx2, int[][]dp){

        if(indx1<0 || indx2<0 ){
            return 0;
        }

        if(dp[indx1][indx2]!=-1){
            return dp[indx1][indx2];
        }

        if(text1.charAt(indx1)== text2.charAt(indx2)){
            return dp[indx1][indx2] = 1+ solve(text1,text2,indx1-1,indx2-1,dp);
        }

        else{
            return dp[indx1][indx2]= Math.max(solve(text1,text2,indx1-1,indx2,dp), solve(text1,text2,indx1,indx2-1,dp));
        }


    }
}