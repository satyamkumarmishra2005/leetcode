class Solution {
    public boolean check(int[] nums) {
        int count = 0;

    int n = nums.length;

    if(nums[n-1] > nums[0]){
            count++;
        }

    for(int i =0 ; i<n-1 ; i++){
        if(nums[i]> nums[i+1]){
            count++;
        }

        if(count > 1){
            return false;
        }
        
    }
    return true;
    }
}