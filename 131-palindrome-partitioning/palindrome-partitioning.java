class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(s,0,ans , new ArrayList<>());

        return ans;
        
    }


    public void backtrack(String s , int indx , List<List<String>> ans , List<String> result){

        if(indx==s.length()){
            ans.add(new ArrayList<>(result));
            return;
        }

        for(int i=indx ; i<s.length(); i++){

            if(isPalindrome(s,indx,i)){
                result.add(s.substring(indx,i+1));

                backtrack(s,i+1,ans, result);

                result.remove(result.size()-1);
            }
        }
    }


    public boolean isPalindrome(String s , int l , int r){

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