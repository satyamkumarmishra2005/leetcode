class Solution {
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return lcs(s,reversed);
    }

     static int lcs(String s , String s1){
        int n = s.length();
        int m = s1.length();
         int [][] dp = new int[n+1][m+1];

        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }

        for(int i = 0 ; i<= n ; i++){
            dp[i][0] = 0;
        }
        
        for(int j =0 ; j<=m ; j++){
            dp[0][j] = 0;
        }

        for(int index1 = 1; index1 <= n ; index1++){
            for(int index2 = 1; index2 <= m ; index2++){

                if(s.charAt(index1-1)== s1.charAt(index2-1)){
                   dp[index1][index2] = 1 + dp[index1 - 1][index2 - 1];
                }

                else{
                     dp[index1][index2] = Math.max(dp[index1 - 1][index2], dp[index1][index2 - 1]);
                }
            }
        }

          return dp[n][m];

     } 
}