class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> result = new ArrayList<>();

        backtrack(candidates , target , 0 , new ArrayList<>() , result );

        return result;
    }

    public void backtrack(int [] candidates , int target , int start , List<Integer> current , List<List<Integer>> result){
    if(start == candidates.length){

    
        if(target==0){
            result.add(new ArrayList<>(current));

        }
            return ;
        }

        // for(int i = start ; i< candidates.length; i++){
        //     int num = candidates[i];

        //     if(num > target){
        //         continue;
        //     }

        //     current.add(num);

        //     backtrack(candidates , target-num , i , current , result);

        //     current.remove(current.size()-1);
        // }

        if(target>= candidates[start]){
            current.add(candidates[start]);
            backtrack(candidates , target- candidates[start] , start , current , result);
            current.remove(current.size()-1);

        }

        backtrack(candidates ,  target , start+1 , current , result);

    }
}