class Solution {
    public int findTargetSumWays(int[] nums, int target) {

     return countways(nums, 0 , 0 , target);

        
    }


    public int countways(int[]nums , int indx , int currsum , int target){

        if(indx==nums.length){

            if(currsum==target){
                return 1;
            }

            return 0;

            
        }



        int plus = countways(nums, indx+1, currsum+nums[indx], target);

        int minus = countways(nums, indx+1 , currsum-nums[indx], target);



        return plus + minus;

        
    }
}