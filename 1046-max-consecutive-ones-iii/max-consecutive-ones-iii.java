class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0;
        int maxlength = 0;
        int zerocnt = 0;

        int n = nums.length;

        for(int j = 0 ; j<n ; j++){
            if(nums[j] == 0){
                zerocnt++;
            }

            while(zerocnt > k){
                if(nums[i]==0){
                    zerocnt--;
                }
                i++;
            }

            maxlength = Math.max(maxlength , j-i+1);  
        }
    return maxlength;
    }
}