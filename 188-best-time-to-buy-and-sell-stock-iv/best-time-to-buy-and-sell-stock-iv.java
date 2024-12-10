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
    int solve(int ind,int buy,int[] prices,int count,int k,int[][][] dp)
    {
        if(ind==prices.length)
        return 0;
        if(count==k)
        return 0;
        if(dp[ind][buy][count]!=-1)
        return dp[ind][buy][count];
        int profit=0;
        if(buy==1 && count<k)
        {
            int op1=-prices[ind]+solve(ind+1,0,prices,count,k,dp);
            int op2=solve(ind+1,1,prices,count,k,dp);
            profit=Math.max(op1,op2);
        }
        else
        {
            int op1=prices[ind]+solve(ind+1,1,prices,count+1,k,dp);
            int op2=solve(ind+1,0,prices,count,k,dp);
            profit=Math.max(op1,op2);
        }
        dp[ind][buy][count]=profit;
        return dp[ind][buy][count];
    }
}