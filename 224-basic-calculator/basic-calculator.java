class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

     int res = 0;
     int num = 0;
     int sign = 1;

     for(char c : s.toCharArray() ){

        if(Character.isDigit(c)){
            num = num *10 + (c-'0');
        }

        else if(c== '+'){
            res = res + num* sign;
            sign= 1;
            num = 0;
        }

        else if (c=='-'){
            res = res + num* sign;
            sign = -1;
            num = 0;
        }

        else if (c=='('){
            stack.push(res);
            stack.push(sign);

            res=0;
            num = 0;
            sign = 1;
        }

        else if (c==')'){
            res = res + num*sign;
            num=0;
            res*= stack.pop();
            res+= stack.pop();

        }
     }
       res+= sign*num;
       return res;
}
}