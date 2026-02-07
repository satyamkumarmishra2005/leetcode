class Solution {
    public int maximumSum(int[] arr) {

        int dp0 = arr[0];
        int dp1 = 0;
        int ans = arr[0];

        for(int i = 1; i< arr.length; i++){
            dp1 = Math.max(dp0 , dp1+ arr[i]);  // deleteing nums[i] current by not picking it and taking the previous value of dp0

            dp0 = Math.max(dp0+ arr[i], arr[i]);

            ans = Math.max(ans, Math.max(dp1, dp0));

        }

        return ans;
        
    }
}