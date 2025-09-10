class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] freq = new boolean[nums.length];

        recurpermutation(result , current , nums , freq);

        return result;


    }

    public void recurpermutation(List<List<Integer>> result ,  List<Integer> current , int[] nums , boolean[] freq  ){

     if(current.size()== nums.length){
        result.add(new ArrayList<>(current));
        return;
     }

     for(int i =0 ; i< nums.length ; i++){
        if(!freq[i]){
            freq[i]= true;
            current.add(nums[i]);
            recurpermutation(result , current , nums , freq);
            current.remove(current.size()-1);
            freq[i] = false;
        }
     }
    }
}