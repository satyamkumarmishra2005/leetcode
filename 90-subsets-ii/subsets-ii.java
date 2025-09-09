class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        

        backtrack(nums , result , new ArrayList<>(), 0 );
        return result;
    }

    public void backtrack(int [] nums , List<List<Integer>> result , List<Integer> current , int indx){

        result.add(new ArrayList<>(current));

       for(int i = indx ; i< nums.length ; i++){
        if(i!=indx && nums[i]== nums[i-1]){
            continue;
        }
        current.add(nums[i]);
        backtrack(nums , result , current , i+1);
        current.remove(current.size()-1);
       }
    

    }
}