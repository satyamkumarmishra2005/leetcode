class Solution {
    // public int longestCommonSubsequence(String text1, String text2) {
    //     // Memoaization
    //     int n = text1.length();
    //     int m = text2.length();

    //     int[][] dp = new int[n][m];

    //     for(int [] rows : dp){
    //         Arrays.fill(rows,-1);
    //     }

    //     return maxsubsequence(text1,text2 , n-1 ,m-1 , dp);

        
    // }

    // static int maxsubsequence(String text1 , String text2 , int index1 , int index2 , int[][] dp){
    //     if(index1 < 0 || index2 < 0){
    //         return 0;
    //     }

    //     if(dp[index1][index2]!= -1){
    //         return dp[index1][index2];
    //     }


    //     if (text1.charAt(index1) == text2.charAt(index2)){
    //     return   dp[index1][index2] =  1 + maxsubsequence(text1 , text2 , index1-1 , index2-1 , dp);
    //     }

    //     else{
    //         return dp[index1][index2] = Math.max(maxsubsequence(text1 , text2 , index1-1 , index2 , dp), maxsubsequence(text1 , text2 , index1 , index2-1 , dp));
    //     }
    // }

    // Tabulation

    public int longestCommonSubsequence(String text1, String text2){
        int n = text1.length();
        int m = text2.length();

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

                if(text1.charAt(index1-1)== text2.charAt(index2-1)){
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