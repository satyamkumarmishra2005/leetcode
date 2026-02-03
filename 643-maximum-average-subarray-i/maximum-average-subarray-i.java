class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j =0;
        double ans = 0.0;

    

        int max = Integer.MIN_VALUE;
        
        int sum = 0;

        while(j< n){
        sum =  sum + nums[j];

        if(j-i +1 < k){
            j++;
        }

        else if (j-i+1 == k){
            max = Math.max(max , sum)  ;

             ans = (max * 1.0) / k ;

           sum = sum - nums[i];

           i++;
           j++;
        }
        }
      return ans;
    }
}