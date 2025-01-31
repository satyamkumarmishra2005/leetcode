class Solution {
    static int ncr(int n , int r){
        int res = 1;
        for(int i =0 ; i< r ; i++){
            res = res * (n-i);
            res = res / (i+1);
          
        }
        return (int ) res;
    }
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();
    for(int row = 1; row<= n ; row++){
         List<Integer> tempLst = new ArrayList<>();
        for(int col = 1 ; col<= row ; col++){
            tempLst.add(ncr(row-1 , col-1));
        }

        ans.add(tempLst);
    }

        

        return ans;
    
}
}