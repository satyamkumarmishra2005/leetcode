class Solution {

    static int countuntil(String s , String t , int index1 , int index2 , int[][] dp){
       if(index2 < 0){
            return 1;
        }
       
        if(index1<0){
            return 0;
        }
        

        if(dp[index1][index2]!=-1){
            return dp[index1][index2];

        }

        if(s.charAt(index1)== t.charAt(index2)){
            return dp[index1][index2] =    countuntil(s,t,index1-1 , index2-1 , dp) + countuntil(s,t,index1-1 , index2 , dp);
        }

        else{
            return dp[index1][index2] = countuntil(s,t,index1-1 , index2 , dp);
        }
        
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int [][] dp = new int [n][m];

        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }
    
    return countuntil(s, t, n-1 , m-1 , dp);


    }
    
 }
// class Solution {
//     static int help(int i, int j, String s, String t, int[][] dp){
//         if (j < 0) return 1;
//         if (i < 0) return 0;
//         if (dp[i][j] != -1) return dp[i][j];
//         if (s.charAt(i) == t.charAt(j)) {
//             return dp[i][j] = help(i - 1, j - 1, s, t, dp) + help(i - 1, j, s, t, dp);
//         } else {
//             return dp[i][j] = help(i - 1, j, s, t, dp);
//         }
//     }

//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();

//         int[][] dp = new int[n][m];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return help(n - 1, m - 1, s, t, dp);
//     }
// }