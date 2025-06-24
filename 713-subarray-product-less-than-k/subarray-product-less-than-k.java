class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       if (k <= 1) {
            return 0;
        }
        int n = nums.length;

        int i = 0;
        int j = 0;
        int prod = 1;
        int count = 0;

        while(j<n){
        prod = prod * nums[j];
         
         while(prod>=k){
            prod = prod / nums[i];
            i++;
         }

         count = count + (j-i+1);
         j++;
        
        }

        return count;

    }
}