class Solution {
   // public int maxProfit(int[] prices) {
        //here we are allowed to do multiple transactions
        //each day we have option yo buy or sell
        //we cant buy if we have alredy buyed a stock and havent sold it
//         int[][] dp=new int[prices.length+1][2];
//         for(int[] c:dp)
//         {
//             Arrays.fill(c,-1);
//         }
//         return solve(0,1,prices,dp);
//         //expecting the function to return the max profit that it can get while starting on index 0 and we can buy
//     }
//     int solve(int ind,int buy,int[] arr,int[][] dp)
//     {
//         if(ind==arr.length)
//         return 0;
//         if(dp[ind][buy]!=-1)
//         return dp[ind][buy];
//         int profit=0;
//         if(buy==1)
//         {
//             //two options buy or not buy
//             //buy
//             int op1=-arr[ind]+solve(ind+1,0,arr,dp);
//             //dont buy
//             int op2=solve(ind+1,1,arr,dp);
//             profit=Math.max(op1,op2);
//         }
//         else
//         {
//             //sell or don't
//             int op1=arr[ind]+solve(ind+1,1,arr,dp);
//             int op2=solve(ind+1,0,arr,dp);// dont sell
//             profit=Math.max(op1,op2);
//         }
//         dp[ind][buy]= profit;
//         return dp[ind][buy];
//     }
 public int maxProfit(int[] prices) {  // if 
    int n = prices.length ;
    int [][] dp = new int[n][2];

    for(int []rows: dp){
        Arrays.fill(rows,-1);
    }

    return solve(prices,0 , 1 , dp , n);
 }

 static int solve(int [] prices , int index, int buy , int [][] dp , int n ){
    if(index== n){
        return 0;
    }

    int profit = 0;

    if(dp[index][buy]!= -1){
        return dp[index][buy];
    }

    if(buy == 1){
        // we have two options either we can buy or skip
        // buy
        int op1 = -prices[index] + solve(prices , index+1 , 0 , dp , n);
        // skip this move for next
        int op2 = solve(prices , index+1 , 1, dp , n);
        profit = Math.max(op1,op2);
    }

    else{  // sell
     int op1 = prices[index] + solve(prices , index+1 , 1 , dp , n);
    
    // skip this
     int op2 = solve(prices , index+1 , 0 , dp , n);

     profit = Math.max(op1 , op2);
         
 }

 dp[index][buy] = profit;
 return dp[index][buy];
}
}