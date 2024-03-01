class Solution {
    public int findDuplicate(int[] nums) {
        // brute force approach 
        // time complexity o(n*n)// as to loops are running 
        // but it exceed the time limit
        /*
        int n = nums.length;
        for(int i =0 ; i<n; i++){
            for(int j = i+1; j<n ; j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
        */
        int len = nums.length;
        int start = 1;
        int end = len-1;
        while(start<end){
            int mid = start + (end-start)/2;
            int cnt = 0;
            for(int i = 0 ; i<len; i++){
            if(nums[i]<= mid){
                cnt++;
            }
        }
        if(cnt<=mid){
            start = mid + 1;
        }
        else{
            end = mid;
        }
    
    }
  return start;  
}
}