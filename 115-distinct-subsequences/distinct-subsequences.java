class Solution {

    // Memoaization

    // static int countuntil(String s , String t , int index1 , int index2 , int[][] dp){
    //    if(index2 < 0){
    //         return 1;
    //     }
       
    //     if(index1<0){
    //         return 0;
    //     }
        

    //     if(dp[index1][index2]!=-1){
    //         return dp[index1][index2];

    //     }

    //     if(s.charAt(index1)== t.charAt(index2)){
    //         return dp[index1][index2] =    countuntil(s,t,index1-1 , index2-1 , dp) + countuntil(s,t,index1-1 , index2 , dp);
    //     }

    //     else{
    //         return dp[index1][index2] = countuntil(s,t,index1-1 , index2 , dp);
    //     }
        
    // }
    // public int numDistinct(String s, String t) {
    //     int n = s.length();
    //     int m = t.length();

    //     int [][] dp = new int [n][m];

    //     for(int [] rows : dp){
    //         Arrays.fill(rows,-1);
    //     }
    
    // return countuntil(s, t, n-1 , m-1 , dp);


    // }
    // Tabulation

     static int countuntil(String s , String t , int index1 , int index2 , int[][] dp){
        // converted to 1 based indexing
       if(index2 == 0){
            return 1;
        }
       
        if(index1==0){
            return 0;
        }
        

        if(dp[index1][index2]!=-1){
            return dp[index1][index2];

        }

        if(s.charAt(index1-1)== t.charAt(index2-1)){
            return dp[index1][index2] =    countuntil(s,t,index1-1 , index2-1 , dp) + countuntil(s,t,index1-1 , index2 , dp);
        }

        else{
            return dp[index1][index2] = countuntil(s,t,index1-1 , index2 , dp);
        }
        
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int [][] dp = new int [n+1][m+1];

        for(int [] rows : dp){
            Arrays.fill(rows,-1);
        }
    
    return countuntil(s, t, n , m , dp);


    }
    
 }
