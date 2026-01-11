class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftproduct = new int[nums.length];
        int [] rightproduct = new int[nums.length];

        leftproduct[0] = 1;
        rightproduct[n-1] = 1;

        for(int i = 1; i<nums.length ; i++){
            leftproduct[i] = nums[i-1] * leftproduct[i-1];
        }

        for(int i = n-2 ; i>= 0 ; i-- ){
            rightproduct[i] = nums[i+1] * rightproduct[i+1];
        }

        int[] result = new int[nums.length];
        for(int i =0 ; i<n ; i++){
        result[i] = leftproduct[i]* rightproduct[i];
    }

    return result;
}
}