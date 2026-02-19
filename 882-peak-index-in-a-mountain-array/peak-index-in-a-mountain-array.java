class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int left = 0;
        int right = arr.length-1;

        while(left< right){
            int mid = left + (right-left)/2;

            if(arr[mid]< arr[mid+1]){ // peak is at the right we are on the ascendoiong slope
              left = mid +1;

            }

           else{ // peak is at the left side we are on the descending slope
           right = mid;
           }
            
        }

        return left;
        
    }
}