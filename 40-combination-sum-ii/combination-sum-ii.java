class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);


        findcombination(candidates , 0 , target , ans , new ArrayList<>());


        return ans;
        
    }




public void findcombination(int [] arr , int indx , int target ,  List<List<Integer>> ans , List<Integer> ds ){

    if(target<0){
        return ;
    }

    if(target==0){
        ans.add(new ArrayList<>(ds));
        return;
    }


    for(int i = indx ; i< arr.length ; i++){

        if(i> indx &&  arr[i] == arr[i-1]){
            continue ; // skip duplicates;
        }



        ds.add(arr[i]); // do 

        findcombination(arr, i+1 , target- arr[i] , ans , ds); // traverse

        ds.remove(ds.size()-1);  // undo


    }
}
}