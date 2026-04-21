class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();


        solve(nums , 0 , result , new ArrayList<>());


        return result;
        
    }


    public void solve(int[] nums , int indx , List<List<Integer>> result , List<Integer> ans){

        if(indx>= nums.length){
            result.add(new ArrayList<>(ans));
            return;
        }


        ans.add(nums[indx]);  // pick 

        solve(nums, indx+1 , result , ans); // explore


        ans.remove(ans.size()-1); // not pick

        solve(nums, indx+1 , result , ans); // explore


    }
}