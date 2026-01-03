class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0 ;
        int j = nums.length-1  ;

        while(i<j){

            if(nums[i]!= 0){
                i++;
            }

            if(nums[j]== 0 ){
                j--;
            
          
        }

        if(nums[i]== 0){
            for(int x = i + 1; x <= j ; x++){
                if(nums[x]!= 0){
                    swap(nums , i , x );
                    break;
                }

                
            }
        }
        }
        
    }

    public void swap (int [] nums , int i , int j){
        int temp = nums[i];
         nums[i] =  nums[j];
        nums[j] = temp;

    }
}