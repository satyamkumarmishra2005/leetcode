class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        findcombination(candidates,0 , target , ans , new ArrayList<>());


        return ans;
    }



public void findcombination(int[] arr, int indx , int target , List<List<Integer>>ans , List<Integer> ds ){



if(indx== arr.length){

    if(target==0){
        ans.add(new ArrayList<>(ds));

    }

    return;
}


   if(arr[indx]<= target){

    ds.add(arr[indx]);

    findcombination(arr, indx, target-arr[indx], ans , ds); // since we can repeat an element as many 
    // times as wanted hence we continue to explore on that index only 

    ds.remove(ds.size()-1);  // remove the last elemnt from datastructure while returning back

   }


   findcombination(arr, indx+1 , target, ans , ds); 

}
}