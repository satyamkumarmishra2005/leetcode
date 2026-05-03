class Solution {
    public int kthGrammar(int n, int k) {
      if(n==1)return 0;
      int mid = (int)Math.pow(2,n-2);
      if(k<=mid){
        return kthGrammar(n-1,k);

      } 
      else{
        int pre=kthGrammar(n-1,k-mid);
        return pre==0?1:0;
      }
    }
}