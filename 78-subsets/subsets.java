class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> result = new ArrayList<>();
       
         helper(nums, ans , result , 0 );

         return ans;
    }

    public void helper(int[] nums ,  List<List<Integer>> ans , List<Integer> result , int indx ){

        if(indx==nums.length){
            ans.add(new ArrayList<>(result));
            return;

        }

        result.add(nums[indx]); // take

        helper(nums, ans, result , indx+1); 

        result.remove(result.size()-1); // backtrack

        helper(nums, ans , result , indx+1); // not take
    }
}