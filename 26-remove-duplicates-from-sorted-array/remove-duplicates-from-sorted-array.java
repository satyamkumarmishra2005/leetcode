class Solution {
    public int removeDuplicates(int[] nums) {
        // Two pointer approach

        int n = nums.length;
       
        int i = 0;
        int j = 1;

        while(j< n){
            if(nums[i]!= nums[j]){ // unique element found  
                i++;
                nums[i] = nums[j]; 
            }
            j++;  // keep searching unique elemnt 
        }
        return i +1 ; // return the length 
    }
}