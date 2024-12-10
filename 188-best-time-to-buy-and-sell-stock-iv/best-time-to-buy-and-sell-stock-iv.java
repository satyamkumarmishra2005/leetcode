class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length][2][k+1];
        for(int[][] t:dp)
        {
            for(int[] c:t)
            {
                Arrays.fill(c,-1);
            }
        }
        return solve(0,1,prices,0,k,dp);
    }
    int solve(int ind,int buy,int[] prices,int cap,int k,int[][][] dp)
    {
        if(ind==prices.length)
        return 0;
        if(cap==k)
        return 0;
        if(dp[ind][buy][cap]!=-1)
        return dp[ind][buy][cap];
        int profit=0;
        if(buy==1 && cap<k)
        {
            int op1=-prices[ind]+solve(ind+1,0,prices,cap,k,dp);
            int op2=solve(ind+1,1,prices,cap,k,dp);
            profit=Math.max(op1,op2);
        }
        else
        {
            int op1=prices[ind]+solve(ind+1,1,prices,cap+1,k,dp);
            int op2=solve(ind+1,0,prices,cap,k,dp);
            profit=Math.max(op1,op2);
        }
       return  dp[ind][buy][cap]=profit;
       // return dp[ind][buy][cap];
    }
}