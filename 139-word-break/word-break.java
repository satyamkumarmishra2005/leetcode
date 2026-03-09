class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        int maxlength = 0;

        for(String word : wordDict){
            maxlength = Math.max(maxlength, word.length()); // maxlength worddict find
        }


        int n = s.length();

        boolean [] dp = new boolean[n+1];

        dp[0] = true;

        for(int i = 1; i<= n ; i++){

            for(int j = i-1; j>= Math.max(0, i-maxlength) ; j-- ){
                if(dp[j] && wordSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }


        return dp[n];
        
    }
}