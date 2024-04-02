class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length ;
        int n = nums2.length ;
        int i = 0;
        int j =0;
     List <Integer> result = new ArrayList<>();
       while(i<m && j<n){
        if(nums1[i]==nums2[j]){
            result.add(nums1[i]);
        
        i++;
        j++;
        }
       else if(nums1[i]<nums2[j]){
        i++;
       }
       else{
        j++;
       }
    }
  return result.stream().mapToInt(Integer::intValue).toArray();
    }
}