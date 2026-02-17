class Solution {
    public int[] searchRange(int[] nums, int target) {

        int [] ans = {-1,-1};

        ans[0] = search(nums, target , true);

        if(ans[0]!= -1){
            ans[1] = search(nums, target , false);
        }


        return ans;
        
        
    }


    public static int search(int[] nums , int target , boolean firstIndex ){

        int left = 0;
        int right = nums.length -1;

        int res = -1;

        while(left<= right){
            int mid = left + (right-left)/2;

            if(nums[mid]> target){
                right = mid - 1;
            }
            else if (nums[mid]< target){
                left = mid +1;
            }

            else{

                res = mid;

                if(firstIndex){
                    right = mid -1;
                }

                else{
                    left = mid +1;
                }

            }
        }

        return res;
    }
}