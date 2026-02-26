class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();

        int n = temperatures.length;

        int[] result = new int[n];

        for(int i =n-1 ; i>=0 ; i--){

            while(!st.isEmpty()){
                int indx = st.peek();

                if(temperatures[indx]> temperatures[i]){
                    result[i] = indx-i;
                    break;
                }

                else{
                    st.pop();
                }
            }


            if(st.isEmpty()){
                result[i] = 0;
                
                
            }
             st.push(i);

            
           

        }
        return result;
    }
}