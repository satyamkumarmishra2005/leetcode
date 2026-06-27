class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        finduniquesubsets(nums , ans , new ArrayList<>(), 0);


        return ans;
        
    }


    public void finduniquesubsets(int[]nums , List<List<Integer>> ans , List<Integer> ds , int indx){

     ans.add(new ArrayList<>(ds));


     for(int i = indx ; i< nums.length; i++){

        if(i> indx && nums[i]== nums[i-1]){
            continue;
        }

        ds.add(nums[i]);

        finduniquesubsets(nums , ans , ds , i+1);

        ds.remove(ds.size()-1);
     }
    }
}