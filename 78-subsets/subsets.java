class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        findsubsets(nums , ans , new ArrayList<>(), 0);

        return ans;

        
    }


    public void findsubsets(int[] nums , List<List<Integer>> ans , List<Integer> ds , int indx){

        if(indx==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[indx]);

        findsubsets(nums, ans , ds , indx+1);

        ds.remove(ds.size()-1);

        findsubsets(nums, ans , ds , indx+1);
    }
}