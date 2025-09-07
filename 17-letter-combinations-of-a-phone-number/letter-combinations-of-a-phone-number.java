class Solution {
      List<String> result = new ArrayList<>();

     public void solve(int indx , String digits , StringBuilder temp ,  Map<Character, String> mp ){
        if(indx>= digits.length()){
            result.add(temp.toString());
            return ;
        }

       char ch = digits.charAt(indx); // 2
        String str = mp.get(ch); // abc

        for(int i =0 ; i< str.length(); i++){
            temp.append(str.charAt(i));
            solve(indx+1 , digits, temp , mp);
            // undo backtrack
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return result;
        }

        Map<Character, String> mp = new HashMap<>();
        
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        
        StringBuilder temp = new StringBuilder();

        solve(0 , digits , temp , mp);

        return result;
    }

 
}