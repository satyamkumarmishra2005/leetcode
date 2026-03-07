class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int k = 0;

        for(char c : s.toCharArray()){

            if(Character.isDigit(c)){
                k = k * 10 + (c - '0');
            }

            else if(c == '['){
                numStack.push(k);
                k = 0;
                stringStack.push("[");
            }

            else if(c == ']'){
                StringBuilder temp = new StringBuilder();

                while(!stringStack.peek().equals("[")){
                    temp.insert(0, stringStack.pop());
                }

                stringStack.pop(); // remove '['

                int count = numStack.pop();
                StringBuilder replacement = new StringBuilder();

                for(int i = 0; i < count; i++){
                    replacement.append(temp);
                }

                stringStack.push(replacement.toString());
            }

            else{
                stringStack.push(String.valueOf(c));
            }
        }

        StringBuilder result = new StringBuilder();

        while(!stringStack.isEmpty()){
            result.insert(0, stringStack.pop());
        }

        return result.toString();
    }
}