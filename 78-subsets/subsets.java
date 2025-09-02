class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        backtrack(ans , subset , 0 , nums);

        return ans;

        
    }

    public void backtrack(List<List<Integer>> ans , List<Integer> subset , int indx , int[] nums){
        if(indx>=nums.length){
            ans.add(new ArrayList<>(subset));
            return ;
        }

        subset.add(nums[indx]);
        backtrack(ans, subset , indx+1 , nums);  // take 

        subset.remove(subset.size()-1);   // notake
        backtrack(ans , subset , indx+1 , nums);
    }
}