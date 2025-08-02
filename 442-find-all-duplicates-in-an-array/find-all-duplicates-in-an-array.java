class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i =0;
        int n = nums.length;

        while(i< n){
            int correct = nums[i]-1;
            if(nums[i]!= nums[correct]){
                swap(nums, correct , i);
            }
            else{
                i++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int index =0 ; index< n ; index++){
            if(nums[index]!= index+1){
                ans.add(nums[index]);
            }
        }
        return ans;
    }

    static void swap(int[] nums , int first , int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
            }
}