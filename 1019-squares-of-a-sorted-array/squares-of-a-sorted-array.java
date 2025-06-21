class Solution {
    public int[] sortedSquares(int[] nums) {
        // // Brute Force

        // int n = nums.length;
        // int [] ans = new int[n]; // created an empty array of size n 

        // for(int i =0 ; i< n ; i++ ){
        //     ans[i] = nums[i]*nums[i];
        // }
        // Arrays.sort(ans);
        // return ans;

        // Optimized using two Pointer

        int n = nums.length;
        int []result  = new int [n];

        for(int i = 0 ; i< n ; i++){
         nums[i] =    nums[i]* nums[i];
        }

        int l = 0 ;
        int r = n-1;

        for(int pos = n-1 ; pos>=0 ; pos--){
            if(nums[l]> nums[r]){
                result[pos] = nums[l];
                 l++;
            }

            else{
                result[pos] = nums[r];
                r--;
            }
            
        }

        return result;
    }
}