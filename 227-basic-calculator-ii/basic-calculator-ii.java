class Solution {
    public int calculate(String s) {

        Stack<Integer> st = new Stack<>();

        int num =0;
        char sign = '+';

        for(int i =0; i< s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){
            num = num * 10 + (c-'0');
            }

            if(!Character.isDigit(c) && c!= ' ' || i ==s.length()-1){

                if(sign=='+'){
                    st.push(num);
                }

                else if(sign=='-'){
                    st.push(-num);
                }

                else if(sign=='*'){
                    st.push(st.pop()*num);
                }

               else if(sign=='/'){
                    st.push(st.pop()/ num);
                }

                sign = c;
                num=0;
            }
        }


       int result = 0;
        for(int n : st){
            result += n;
        }

        return result;
        
    }
}