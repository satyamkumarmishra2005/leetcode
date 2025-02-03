class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mindx = m-1;
        int nindx = n-1;

        int right = m+n-1;

        while(nindx>=0){
            if(mindx>=0 && nums1[mindx]> nums2[nindx]){
                nums1[right] = nums1[mindx];
                mindx--;
            }
            else{
                nums1[right] = nums2[nindx];
                nindx--;
            }

            right--;
        }
    }
}