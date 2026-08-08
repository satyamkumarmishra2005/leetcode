class Solution {
    public int minCut(String s) {

        int n = s.length();

        int [] dp = new int[n];

       Arrays.fill(dp,-1);


        return solve(s,n,0,dp);
        
    }


    public int solve(String s , int n , int i, int[]dp){

        if(i==n){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }
         
         int mincuts = Integer.MAX_VALUE;

        for(int j = i ; j<n ; j++){
           
           

            if(isPalindrome(s,i,j)){
                int cuts;


                if(j==n-1){  // last index then no cut needed;
                 cuts =0;
                }

                else{
                    cuts = 1+ solve(s,n,j+1,dp);
                }

                mincuts = Math.min(mincuts, cuts);
            }
        }


        return dp[i] = mincuts;
    }


    boolean isPalindrome(String s, int i , int j){

        while(i<j){

            if(s.charAt(i)!=s.charAt(j)){
                return false;

            }
            i++;
            j--;
        }

        return true;
    }
}