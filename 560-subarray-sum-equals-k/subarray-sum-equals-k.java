class Solution {
    public int subarraySum(int[] nums, int k) {
        //Optimal
        //(sum , count)
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0,1); // for the test case if the value of k=0

        int sum =0;
        int ans = 0;

        for(int j =0 ; j<n ; j++){
            sum+= nums[j];
            if(map.containsKey(sum-k)){
                ans+= map.get(sum-k);
            }

            map.put(sum, map.getOrDefault(sum , 0)+1);
        }
     return ans;

    }
}