class Solution {
    // Using recurrsion 
    // Tc = O(n) * O(n)
    

    
     public int fib(int n) {

    //     if(n<2){
    //         return n;
    //     }
    //     return fib(n-1) + fib(n-2);
    // }


    // Using Memoization
    //  static int fibbo(int n , int [] dp){
    //     // Using Memoization
    //     if(n<=1){
    //         return n;
    //     }
    //     if(dp[n]!= -1){
    //         return dp[n];
    //     }

    //     return dp[n] = fibbo(n-1 ,dp) + fibbo(n-2 , dp);
    // }

    //  int [] dp = new int[n+1];
    //     Arrays.fill(dp ,-1);
    //     return fibbo(n , dp);



    // using tabulation 
    if(n== 0){
        return 0;
    }

    if(n==1){
        return 1;
    }
     
     int [] dp = new int [n+1];

       dp[0] = 0;
       dp[1] = 1;

       for(int i =2 ; i< n+1 ; i++){
           dp[i] = dp[i-1] + dp[i-2];
       }

       return dp[n];
   

     }

}