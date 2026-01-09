class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer , Integer> map = new HashMap<>();

        int sum =0;
        int ans = 0;


        map.put(0,1);  

        for(int i = 0 ; i< nums.length ; i++){

            sum+= nums[i];
           
           // we are not directly doing sum % k because the arary contains negative number also 

            int rem = ((sum % k ) + k )%k ;  

            if(map.containsKey(rem)){
                ans+= map.get(rem);
            }

            map.put(rem , map.getOrDefault(rem,0)+1);
        }
       

       return ans;
        
    }
}