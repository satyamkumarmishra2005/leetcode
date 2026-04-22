class Solution {

     Set<Integer> st = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        solve(nums , result , new ArrayList<>());

        return result;
    } 


    public void solve(int [] nums , List<List<Integer>> result , List<Integer> temp){

       

        if(temp.size()== nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i< nums.length ; i++){

            if(!st.contains(nums[i])){

                temp.add(nums[i]);
                st.add(nums[i]);

                solve(nums , result , temp);


               temp.remove(temp.size()-1);

               st.remove(nums[i]);    
            }
        }

        


    }
}