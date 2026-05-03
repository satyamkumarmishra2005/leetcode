class Solution {
    public int minImpossibleOR(int[] nums) {
        Map<Integer,Integer> nm=new HashMap<>();
        for(int i:nums)
        {
            nm.put(i, nm.getOrDefault(i,0)+1);
        }
        int x=1;
        while(nm.containsKey(x))
        {
            x*=2;
        }
        return x;
    }
}