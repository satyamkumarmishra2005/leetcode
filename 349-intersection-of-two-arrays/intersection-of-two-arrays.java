class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set <Integer> s = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i<nums1.length ; i++){
            s.add(nums1[i]);
        }

        for(int i =0 ; i<nums2.length ; i++){
            if(s.contains(nums2[i])){
                result.add(nums2[i]);
                s.remove(nums2[i]);
            }
        }
         return result.stream().mapToInt(Integer::intValue).toArray();
    }
}