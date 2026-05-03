class Solution {
   public int totalHammingDistance(int[] nums) {
        int result = 0;
        for(int i = 0 ; i< 32 ;i++){
            int count_ones = 0;

            for(int j = 0;j<nums.length;j++){
                count_ones += (nums[j]>>i) & 1; // count no of 1's at a specific position
            }
            result += (count_ones*(nums.length-count_ones));
        }

        return result;
    }
}