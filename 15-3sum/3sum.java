class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
  
        int n = nums.length ;
     Arrays.sort(nums);// Sort the input array nums in non-decreasing order. Sorting the array helps in avoiding duplicate triplets.

        for(int i = 0 ; i< nums.length ; i++){
            if(i> 0  && nums[i]== nums[i-1]){  // Check if the current element is a duplicate of the previous element and skip it if it is.
                continue;  
            }

            int j = i+1; // Use a two-pointer approach with pointers j and k to find triplets whose sum equals zero.
            int k = n-1;

            while(j<k){
                int total = nums[i] + nums[j] + nums[k];  // Calculate the total sum of the current triplet.

                if(total > 0){   //If the total sum is greater than zero, decrement the k pointer to decrease the total sum.
                    k--;
                }

               else if(total < 0){   // If the total sum equals zero, add the triplet [nums[i], nums[j], nums[k]] to the result list res.
                    j++;
                }

                else{
                    res.add(Arrays.asList(nums[i], nums[j] , nums[k]));  // If the total sum equals zero, add the triplet [nums[i], nums[j], nums[k]] to the result list res.
                    j++;     // Increment the j pointer to skip any duplicate elements

                    while(nums[j]== nums[j-1] && j< k){
                        j++;
                    }
                }


            }
        }

        return res; // Return the list res containing all the unique triplets whose sum is zero.

    }
}