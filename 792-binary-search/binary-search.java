class Solution {
    public int search(int[] nums, int target) {

    return binarysearch(nums, 0 , nums.length-1 , target);
        
    }


    public int binarysearch(int[] nums , int left , int right , int target){

        if(left> right){
            return -1;
        }

        int mid = left + (right-left)/2;

        if(nums[mid]== target){

            return mid;


        }

        if(target< nums[mid]){
            return binarysearch(nums, left , mid-1, target);
        }

        
     return binarysearch(nums, mid+1 , right, target);
        
    }
}