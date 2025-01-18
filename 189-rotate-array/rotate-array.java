class Solution {
    public void rotate(int[] nums, int k) {
        // optimised solution
        // Time complexity = O(N)
        // Spcae complexity = O(1)
        int n = nums.length;  // The number of rotations k is updated to k % n to handle cases 
        //where k is greater than n. This ensures that rotating the array n times results in the same array, so any extra rotations beyond n can be ignored.
         k = k % n ;
        reverse(nums,0 , n-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , n-1);
    }

    public void reverse(int [] nums,int start , int end){
        while(start< end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++ ;
            end --;
        }
    }
}