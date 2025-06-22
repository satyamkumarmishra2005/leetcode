class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         //Better   Used hashSet
        // if(nums== null && nums.length < 3){
        //     return new ArrayList<>();
        // }
        // Set<List<Integer>> res = new HashSet<>(); // we have used hashset here to avoid duplication
        // int n = nums.length;
        // Arrays.sort(nums);

        // for(int i =0 ; i< n-2 ; i++){
        //     int j = i+1;
        //     int k = n-1;

        //     while(j<k){
        //         int sum = nums[i]+ nums[j] + nums[k];

        //         if(sum==0){
        //          res.add(Arrays.asList(nums[i], nums[j], nums[k]));   
        //          j++;
        //          k--;
        //             }

        //         else if(sum<0){
        //             j++;
        //         }
        //         else{
        //             k--;
        //         }
        //     }
        // }
        // return new ArrayList<>(res);


    // More optimal Without Hahset
  List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1, k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // Skip duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    // Skip duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) k--;

                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}