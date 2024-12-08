class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }

        return editdistance(word1,word2 , n-1 , m-1 , dp);
        
    }

    static int editdistance(String word1 , String word2 , int i , int j , int[][]dp){
        if(i<0){
            return j+1;
        }

        if(j<0){
            return i+1;
        }

        if(dp[i][j]!= -1){
            return dp[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
        return dp[i][j] = editdistance(word1 , word2 , i-1 , j-1 , dp);
        }

        else{
            return dp[i][j] = 1 + Math.min(editdistance(word1, word2, i - 1, j - 1, dp),
                    Math.min(editdistance(word1, word2, i - 1, j, dp), editdistance(word1, word2, i, j - 1, dp)));
        }


    }
}