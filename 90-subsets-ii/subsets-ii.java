class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {


List<List<Integer>> result = new ArrayList<>();


    Arrays.sort(nums);


        solve(nums , 0 , result , new ArrayList<>());


        return result;
    }



    public void solve(int [] nums , int indx ,List<List<Integer>> result , List<Integer> ans ){

            result.add(new ArrayList<>(ans));

        for(int i = indx ; i< nums.length ; i++){

            if(i> indx && nums[i]== nums[i-1] ){
                continue; // skip the duplicate
            }

            ans.add(nums[i]);  // do

            solve(nums , i+1 , result , ans); // travese

            ans.remove(ans.size()-1); // undo
        }
    }
}