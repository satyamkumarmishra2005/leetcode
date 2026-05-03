class Solution {
    public boolean xorGame(int[] nums){
      int xor=0;
      int c=0;
      int n=nums.length;
      for(int i=0;i<nums.length;i++){
        xor^=nums[i];
        if(nums[i]==0){
            c++;
        }
      }
      if(xor==0){
        return true;
      }
      if(n%2==0){// even ho length // xor 0 ho to alice jitega
        return true;
      }
      return false;


        
    }
}