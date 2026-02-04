class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i =0;
        int j =0;
        int count =0;

        int n = nums.length;
        int product = 1;

        if(k<=1){
            return 0;
        }

        while(j<n){
            product = product * nums[j];

            while(product>=k){
                product = product / nums[i];
                i++;
            }

            count = count + (j-i+1);
            j++;

        }

        return count;
    }
}