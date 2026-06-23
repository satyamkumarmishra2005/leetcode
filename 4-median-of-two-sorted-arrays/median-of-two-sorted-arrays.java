class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;


        int[] temp = new int[m+n];

        int l =0;
        int r = 0;
        int k =0;


        while(l< m && r< n){

            if(nums1[l]< nums2[r]){
                temp[k++] = nums1[l++];
            }

            else{
                temp[k++] = nums2[r++];
            }

        }


        while(l<m){
            temp[k++] = nums1[l++];
        }

        while(r<n){
            temp[k++] = nums2[r++];
        }


        int size = m+n;

        if(size%2!=0){
            return temp[size/2];
        }


        return (temp[size/2] + temp[(size/2)-1])/ 2.0;
        
    }
}