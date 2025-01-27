class Solution {
    // optimized 
    // Time complexity = O(N)
    // Space complexity =O(N)
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int [] ans= new int[nums.length];
        int pos = 0;
        int neg = 1;

        for(int i = 0 ; i< n ; i++){
            if(nums[i]>0){
                ans[pos]= nums[i];
                pos+= 2;
            }
            else{
                ans[neg] = nums[i];
                neg+= 2;
            }
        }

        return ans;

        
    }
}