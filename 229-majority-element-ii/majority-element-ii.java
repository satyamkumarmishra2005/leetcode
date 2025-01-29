class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i =0 ; i< n ; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }


        List<Integer> majorityElements = new ArrayList<>();

         for(Integer Key : map.keySet()){
            if(map.get(Key)>n/3){
             majorityElements.add(Key);
            }
        }
      return majorityElements;
    }
}