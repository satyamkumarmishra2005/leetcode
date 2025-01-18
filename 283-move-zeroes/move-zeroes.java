class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;

        int j = -1 ;
        for(int i = 0 ; i< n ; i++){
            if(nums[i]==0){  // if any elemnt is found zero the we will assign those index as j 
                j=i ;
                break;
            }
        } 

        if(j==-1){
            return ;
        }


   // if the elemnt is not zero then swap it with the zero element position 

        for(int i = j+1 ; i < n ; i++){
            if(nums[i]!= 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp ;
                j++;
            }
        }
    }
}