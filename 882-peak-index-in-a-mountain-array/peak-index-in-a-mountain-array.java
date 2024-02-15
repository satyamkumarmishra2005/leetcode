class Solution {
    public int peakIndexInMountainArray(int[] arr) {
          int start = 0;
         int end = arr.length-1;

         while(start < end){
             int mid = start + (end- start) / 2;
             if(arr[mid] > arr[mid+1]){
                 // you are in decreasing part of array
                 // this may be the ans, but look at left
                 // this is why end not equal to mid - 1;
                 end = mid;
             }
             else{
                 // you are in ascending part of the array
                 start = mid+1 ;// because we know at mid + 1 element > mid element because
             }
         }
         // ind the end , start == end and pointing to the largest number because of the 2 checks
        // start and end are always trying to find max element in the above 2 checks
        // hence when they are pointing to just one element , that is the max one because that is what the checks say
      // and if we are saying that only one item is remaining , hence cuz of above line that is the best possible ans
       return start; // or end as both are equal
        }

    }
