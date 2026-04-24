class Solution {
    public List<String> generateParenthesis(int n) {
        

        List<String> ans = new ArrayList<>();


        backtrack(ans , "", 0,0,n);


        return ans;


    }


    public void backtrack(List<String> ans , String str , int open , int close , int max){


        if(str.length()== max*2){
            ans.add(str);

            return;
        }


        if(open< max){
            backtrack(ans, str+"(", open+1, close , max);
        }

        if(close< open){
            backtrack(ans , str+")" , open , close+1 , max);
        }
    }
}