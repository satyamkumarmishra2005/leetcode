class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;

        int totalsum = n * (n+1) / 2;

        int arraysum = 0;

        for(int num : nums){
            arraysum+= num ;
        }

        return totalsum - arraysum ;
    }
}