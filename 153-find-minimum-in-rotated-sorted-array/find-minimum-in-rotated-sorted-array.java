class Solution {
    public int findMin(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int num : nums){
            min = Math.min(min , num);
        }


        int target = min;

        int left = 0;

        int right = nums.length-1;

        while(left<= right){

            int mid = left + (right-left)/2;

            if(nums[mid]== target){
                return nums[mid];
            }

            if(nums[left]<= nums[mid]){ // left half is sorted
            
            if(nums[left]<= target && target <= nums[mid]){
                right = mid-1;
            }

            else{
                left = mid +1;
            }
            }


            else{  // right half is sorted

            if(nums[mid]<= target && target<= nums[right]){
                left = mid +1;
            }

            else{
                right = mid -1;
            }

            }
        }

        return min;
        
        
    }
}