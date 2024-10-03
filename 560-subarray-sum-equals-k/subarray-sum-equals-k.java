class Solution {
    public int subarraySum(int[] arr, int k) {
         HashMap<Integer , Integer> map = new HashMap<>();
        //(sum,count)
        map.put(0,1); // edge case if the sum of entire array is equal to k
        int sum =0 ;
        int ans = 0 ;
        for(int j =0 ; j<arr.length ; j++){
            sum+= arr[j];
            if(map.containsKey(sum-k)){
                ans+= map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}