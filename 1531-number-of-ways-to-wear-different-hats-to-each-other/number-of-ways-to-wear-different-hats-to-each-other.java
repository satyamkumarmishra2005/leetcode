class Solution {
    int mod = 1000000007;
    int dp[][];
    int totalPeople;
    public int numberWays(List<List<Integer>> hats) {
        dp = new int[41][(1<<(hats.size()+1))-1];
        List<Integer>[] people = new List[41];

        totalPeople = hats.size();
        for(int i=0 ; i<=40 ; i++){
            people[i] = new ArrayList<>();
        }
        for(int i=0 ; i<hats.size(); i++){
            for(int j=0 ; j<hats.get(i).size() ; j++){
                people[hats.get(i).get(j)].add(i);
            }
        }
        for(int i=0 ; i<dp.length ; i++){
            for(int j=0 ; j<dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return helper(people,0, 0, 0);
    }
    int helper(List<Integer>[] people, int bitmask, int n, int placed){
        if(placed==totalPeople) return 1;
        if(n== 41){
            return 0;
        }
        if(dp[n][bitmask]!=-1) return dp[n][bitmask];

        int count = helper(people,bitmask, n+1,placed)%mod;
        for(int i=0; i<people[n].size() ; i++){
            int x = people[n].get(i);
            if((bitmask&(1<<x))!=0) continue;

            count = (count+helper(people,(bitmask|(1<<x)), n+1,placed+1)%mod)%mod;
        }
        return dp[n][bitmask] = count;
    }
}