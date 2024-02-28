class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int start = 0;
        int end  = n-1;
       // int mid = -1;
        while(start<=end){
             int  mid = start + (end-start)/2;

            int kitne_missing_till_end = arr[mid] - ( mid + 1);

            if(kitne_missing_till_end < k){
                start = mid + 1;
            }
        
        else{
            end = mid - 1;
        }
    }
    return start + k;
}
}