class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        

        List<List<Integer>> ans = new ArrayList<>();

        findcombinationSum(candidates, target,ans, new ArrayList<>(), 0);

        return ans;
    }


    public void findcombinationSum(int[] candidates, int target,List<List<Integer>> ans, List<Integer> ds , int indx ){

        if(indx==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            
            }

            return;
        }


        if(candidates[indx]<= target){
            ds.add(candidates[indx]);
            findcombinationSum(candidates, target-candidates[indx], ans,ds, indx );
            ds.remove(ds.size()-1);
        }

        findcombinationSum(candidates, target , ans , ds , indx+1);
    }
}