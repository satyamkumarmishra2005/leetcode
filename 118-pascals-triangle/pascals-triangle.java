class Solution {
    static int ncr(int n , int r){
        int res = 1;
        for(int i =0 ; i< r ; i++){
            res =  res * (n-i);
            res = res/(i+1);
        }
        return (int) res;
    }
    public List<List<Integer>> generate(int numRows) {
        int n = numRows;
        List<List<Integer>> ans = new ArrayList<>();


        for(int row = 0 ; row < n ; row++){
            List<Integer> temp = new ArrayList<>();
            for(int col = 0 ; col<= row ; col++){
              temp.add(ncr(row, col));  
            }
         ans.add(temp);
        }
        return ans;
    }
}