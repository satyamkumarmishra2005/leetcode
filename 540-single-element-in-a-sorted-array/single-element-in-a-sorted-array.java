class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
         int start = 0, end = n-1;
        int mid;
        
        while(start < end) {
            mid = start + (end-start)/2;
            boolean isEven = (end-mid)%2==0;
            
            if(nums[mid] == nums[mid+1]) {
                if(isEven) {
                    start = mid+2;
                } else {
                    end = mid-1;
                }
            } else if(nums[mid] == nums[mid-1]) {
                if(isEven) {
                    end = mid-2;
                } else {
                    start = mid+1;
                }
            } else {
                return nums[mid];
            }
        }
        
        return nums[end]; //or, nums[r]
    }
};