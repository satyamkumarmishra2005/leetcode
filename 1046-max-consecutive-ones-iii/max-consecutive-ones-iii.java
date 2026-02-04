class Solution {
    public int longestOnes(int[] nums, int k) {
        

        int i = 0;
        int maxlength = 0;
        int zerocount = 0;

        int n = nums.length;

        for(int j =0 ; j< n ; j++){
            if(nums[j]==0){
                zerocount++;
            }

            while(zerocount> k){
             if(nums[i]==0){
                zerocount--;
             }
             i++;
            }

            maxlength = Math.max(maxlength, j-i+1);
        }

        return maxlength;
    }
}