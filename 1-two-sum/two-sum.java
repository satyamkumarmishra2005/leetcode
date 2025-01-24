class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i< n ; i++){
            int compliment = target-nums[i];
             // Check if the complement exists in the map
            if(map.containsKey(compliment)){
                return new int[] {map.get(compliment),i};
            }
          // Store the current value and index in the map
            map.put(nums[i],i);
        }
        // If no solution is found
        return new int[0];

    }
}