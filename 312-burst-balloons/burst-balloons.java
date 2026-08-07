class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length;

        int[][]dp = new int[n+2][n+2];

        int[] arr = new int[n+2];

        arr[0] = 1;

        arr[n+1] = 1;

        for(int i = 0 ; i< n ; i++){
            arr[i+1] = nums[i];
        }

        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        
        return solve(1,n,arr,dp);
    }


    public int solve(int i , int j , int[]arr, int[][]dp){

        if(i>j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        for(int indx = i ; indx<=j; indx++){

            int cost = arr[i-1] * arr[indx] * arr[j+1] + solve(i,indx-1, arr,dp) + solve(indx+1,j,arr,dp);

             max = Math.max(cost,max);
        }

     


      return dp[i][j] = max;

    }
}