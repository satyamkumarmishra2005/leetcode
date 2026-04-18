class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);


        findcombination(candidates , 0 , target , ans , new ArrayList<>());


        return ans;
        
    }



    public void findcombination(int[] arr , int index , int target , List<List<Integer>> ans , List<Integer> ds ){

        if(target==0){
            ans.add(new ArrayList<>(ds));
        }

        for(int i = index ; i < arr.length ; i++){

            if(i> index && arr[i]== arr[i-1]){
                continue;
            }

            if(arr[i]> target){
                break;
            }

            ds.add(arr[i]);

            findcombination(arr, i+1 , target-arr[i], ans , ds);

            ds.remove(ds.size()-1);
        }
    }
}