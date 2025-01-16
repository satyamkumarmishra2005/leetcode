class Solution {
   // Time complexity = O(N)
   // Space complexity = O(N)

   //Approch 1

   // Here first we will create a Map which stores the frequency of the nums1 and nums2 array
   // if the frequency of number is 2 then the Xor of that number will be Zero because the Xor of same elemnts is zero
   // hence of the frequency of any element is odd then the answer will be Xor of those element we will store them in result 
   // and return the result
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int num : nums1){
            mp.put(num , mp.getOrDefault(num , 0) + n);
        }


        for(int num : nums2){
            mp.put(num , mp.getOrDefault(num,0) + m);
        }
       
       int result = 0;

       for(int num : mp.keySet()){
        if(mp.get(num)%2 != 0){
            result ^= num ;
        }
       }
        return result;
    }
}