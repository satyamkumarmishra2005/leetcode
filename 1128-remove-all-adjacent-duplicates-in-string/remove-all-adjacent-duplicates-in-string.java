class Solution {
    public String removeDuplicates(String s) {

        int n = s.length();

         Stack<Character> st = new Stack<>();

         StringBuilder sb = new StringBuilder();

        for(int i = 0; i< n ; i++){

            if(st.isEmpty()){
                st.push(s.charAt(i));
            }

            else if (st.peek()== s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }


        }
    while(!st.isEmpty()){
        sb.append(st.pop());
    }

    sb.reverse();

    return sb.toString();

        
    }
}