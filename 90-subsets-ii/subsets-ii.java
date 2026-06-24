class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();

        findsubsets(nums , 0 , ans , new ArrayList<>());

        return ans;
    }


    public void findsubsets(int[] nums , int indx , List<List<Integer>> ans , List<Integer> ds){

     
     ans.add(new ArrayList<>(ds));

     for(int i = indx ; i< nums.length ; i++){

        if(i> indx && nums[i]==nums[i-1]){
            continue;
        }

        ds.add(nums[i]);

        findsubsets(nums , i+1, ans , ds);
        

        ds.remove(ds.size()-1);

     }

    }
}