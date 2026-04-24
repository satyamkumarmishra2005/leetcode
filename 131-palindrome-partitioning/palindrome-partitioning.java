class Solution {
    public List<List<String>> partition(String s) {
        

        List<List<String>> result = new ArrayList<>();


        backtrack(s, 0 , result , new ArrayList<>());


        return result;


    }


    public void backtrack(String s , int indx ,  List<List<String>> result , List<String> curr){

        if (indx == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }


        for(int i = indx ; i<s.length() ; i++){

            if(ispalindrome(s, indx , i)){

                curr.add(s.substring(indx , i+1));

                backtrack(s, i+1 , result , curr);

                curr.remove(curr.size()-1);

            }
        }
    }


    public boolean ispalindrome(String s , int l , int r){
         
         while(l<r){


            if(s.charAt(l)!= s.charAt(r)){
                return false;
            }

            l++;
            r--;

         }


         return true;
    }
}