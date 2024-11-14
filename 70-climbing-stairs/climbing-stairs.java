class Solution {
    public int climbStairs(int n) {
        // It will give time limit exced
//         if(n<0){
//             return 0;
//         }

//         if(n == 0){
//             return 1; // we have got one way to cover all stairs
//         }

//         int one_step = climbStairs(n-1);
//         int two_step = climbStairs(n-2);

//         return one_step + two_step;
//     }
// }

 int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];        
    }
}