class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestsum = 100000;
        Arrays.sort(nums);

    for(int i =0 ; i< n-2 ; i++){
        int j = i+1;
        int k = n-1;

        while(j<k){
            int sum = nums[i] + nums[j] + nums[k];

            if(Math.abs(target-sum)< Math.abs(target-closestsum)){
                closestsum = sum;
            }
        
        if(sum== target) return target;
        else if (sum< target) j++;
        else k--;
    }
       
    }
     return closestsum;

}
}