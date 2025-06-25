class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int n = nums.length;
        int[] snums = nums.clone();

        Arrays.sort(snums);
        int start = snums.length;
        int end = 0;

        for(int i =0 ; i<snums.length ; i++){
            if(snums[i]!= nums[i]){
                start = Math.min(start , i);
                end = Math.max(end , i);
            }
        }

        if(end-start >=0 ){
        return end-start + 1;
}
        return 0 ;
    }
}