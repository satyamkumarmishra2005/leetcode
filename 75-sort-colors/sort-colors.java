class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int k = 0;

        while( k <=j ){
            if(nums[k]== 0){
                swap(nums, k , i);
                 i++; 
             k++;
            }

           else if(nums[k]==2){
                swap(nums,k,j);

               //  k++;
            j--;
            }

            else{
                k++;
            }
        }


    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



//the task is to bring all zeros to left and all twos to right. that's it

// detailed hint below

// 1)- use three pointers one for left end , one for right end and one for iteration.
// 2)-if you see 0 swap it with left pointer and increase the left pointer by one.
// 3)-if you see 2 swap it with right pointer and decrease right pointer by one.
// 4)-else increase the iterating pointer.
// 5)-run this loop while the iterating pointer<=right pointer.
// right pointer=n-1
// left pointer=0
// iterating pointer =0 runs while it is<=right pointer.