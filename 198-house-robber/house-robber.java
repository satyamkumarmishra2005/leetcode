class Solution {

  // Memoaization
//     public int rob(int[] nums) {
//         int n = nums.length;
//         int dp [] = new int [n];

//         Arrays.fill(dp , -1);
//         return solve(n-1 , nums , dp);
        
//     }

//     static int solve(int index , int [] nums , int [] dp){

//         if(index < 0){
//             return 0;
//         }
//         if(index == 0){
//             return nums[index];
//         }

//         if(dp[index]!= -1){
//             return dp[index];
//         }

//         int pick = nums[index] + solve(index-2 , nums , dp);
//         int nonpick = solve(index-1 , nums , dp);

//         return dp[index] = Math.max(pick , nonpick);
//     }
// }


// Tabulation
public int rob(int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    if (n == 1) return nums[0];

    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);

    for (int i = 2; i < n; i++) {
        int pick = nums[i] + dp[i - 2];
        int notPick = dp[i - 1];
        dp[i] = Math.max(pick, notPick);
    }

    return dp[n - 1];
}


}
