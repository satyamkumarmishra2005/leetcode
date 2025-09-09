class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates , result , new ArrayList<>(), target , 0);

        return result;
        
    }

    public void backtrack(int [] candidates , List<List<Integer>> result , List<Integer> current , int target , int indx ){

        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = indx ; i< candidates.length ; i++){

            if(i> indx && candidates[i]== candidates[i-1]){
                continue;
            }

            int num = candidates[i];

            if(num> target){ // since sorted no need to continue
                break;
            }

            current.add(num);

            backtrack(candidates , result , current , target-num , i+1);
            current.remove(current.size()-1); // backtrqaqck
        }

   

    }


}