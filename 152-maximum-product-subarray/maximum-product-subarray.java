class Solution {
    public int maxProduct(int[] nums) {

        int currmax = nums[0];
        int currmin = nums[0];

        int maxproduct = nums[0];

        for(int i = 1; i< nums.length ; i++){

            if(nums[i]<0){
                int temp = currmax;
                currmax = currmin;
                currmin = temp;
            }

            currmax = Math.max(currmax*nums[i], nums[i]);
            currmin = Math.min(currmin* nums[i], nums[i]);

            maxproduct = Math.max(maxproduct , currmax);
        }
        return maxproduct;
    }
}