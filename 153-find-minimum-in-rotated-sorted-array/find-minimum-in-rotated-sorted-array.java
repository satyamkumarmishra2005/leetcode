class Solution {
    public int findMin(int[] nums) {

        int left =0;
        int right = nums.length-1;

        while(left< right){

            int mid = left + (right-left)/2;

            if(nums[mid]> nums[right]){  // the minimum is in right side
                left = mid +1 ;
            }

            else{
                right = mid ;  // not right =  mid -1 because mid can also be minimum;
            }
        }


        return nums[left];
        
    }
}