class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        findcombination(0, ans , candidates , target , new ArrayList<>());

        return ans;
    }


    public void findcombination(int indx , List<List<Integer>> ans , int[] candidates, int target , List<Integer> ds){

        if(indx== candidates.length){

            if(target==0){
                ans.add(new ArrayList<>(ds));
            }


            return;
        }


        if(candidates[indx]<= target){

            ds.add(candidates[indx]);

            findcombination(indx, ans , candidates , target-candidates[indx], ds);

            ds.remove(ds.size()-1);
        }


        findcombination(indx+1 , ans ,candidates , target, ds);
    }
}