class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int low = 0;
        int high = 0;
        int n = nums.length;
        int sum =0;
        int result = Integer.MAX_VALUE;

        while(high< n){

            sum+= nums[high];

            if(sum < target){
                high++;
            }
        
        else if(sum >= target){
            while(sum>=target){
                sum = sum - nums[low];
                result = Math.min(result , high-low+1);

                low++;

            }

            high++;
        }


        

        }

        if(result== Integer.MAX_VALUE){
            return 0;
        }


        return result;
        
    }
}