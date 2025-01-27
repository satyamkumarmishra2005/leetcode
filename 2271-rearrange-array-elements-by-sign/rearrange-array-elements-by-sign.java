class Solution {
    public int[] rearrangeArray(int[] nums) {
        // Brute force
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
     for(int num : nums){
        if(num> 0){
            pos.add(num);
        }
        else{
            neg.add(num);
        }
     }

    for(int i=0 ; i< n/2 ; i++){
        nums[2*i] = pos.get(i);
        nums[2*i+1] = neg.get(i);
    }

    return nums;
    }
}