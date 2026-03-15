class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for(int i= 0 ; i< s.length(); i++){

            char c = s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()- c  ) == 32){
                st.pop();
            }  

            else{
                st.push(c);
            }

        }


        StringBuilder str = new StringBuilder();
          while(!st.isEmpty()){
            str.append(st.pop());
          }

    return str.reverse().toString();

    }
}