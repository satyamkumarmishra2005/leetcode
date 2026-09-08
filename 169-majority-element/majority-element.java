class Solution {
    public int majorityElement(int[] nums) {

        int ans =0;
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        for(Integer key : map.keySet()){

            if(map.get(key)>n/2){
                ans=key;
            }

        }

        return ans;


        
    }
}