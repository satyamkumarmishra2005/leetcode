class Solution {
    public int missingNumber(int[] nums) {


    // cyclic sort 
    // Time complexity: O(N)
    // space complexity : O(1)
        int i = 0;
        int n = nums.length;

        while(i< n){
            int correct = nums[i];

            if(nums[i]< n && nums[i]!= nums[correct]){
                swap(nums , i , correct);
            }
            else{
                i++;
            }
        }

        for(int x =0 ; x< n ; x++){
            if(nums[x]!= x){
                return x;
            }
        }


        return n ;
        
    }

    static void swap(int[] nums , int first , int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}