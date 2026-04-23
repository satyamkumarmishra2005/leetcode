class Solution {
    public void nextPermutation(int[] nums) {

        int gola_index = -1;

        for(int i = nums.length-1 ; i>0 ; i--){

            if(nums[i]> nums[i-1]){
                gola_index = i-1; // we have found the first breakijng point gola_index

                break;
            }
        }

    


     if(gola_index!=-1){

        int swap_index = gola_index;


        for(int j = nums.length-1 ; j>= gola_index+1 ; j--){  // the just greater elemnt after (right side) the   goal_index  or num[i-1]
        

        if(nums[j] > nums[gola_index]){

            swap_index = j;

            break;
        }


        }



        swap(nums ,gola_index , swap_index); // swap the gola index and the next just greater index 




     }




     reverse(nums, gola_index+1); // revese the rest half after tghe gola index


        
    }


    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int[] nums,int start){
        int i=start;
        int j=nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}