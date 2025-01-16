class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
     // Most optimized approch
     
     // if nums1. length = odd then the answer will be xor of nums2 element
     // if nums2.length = odd then the answer will be xor of nums1 element
        int m = nums1.length;
        int n = nums2.length;

        int xor = 0;

        if(m% 2!= 0){
            for(int num : nums2){
                xor ^= num ;
            }
        }

        if(n%2 != 0){
            for(int num : nums1){
                xor ^= num ;
            }
        }

        return xor;
    }
}