class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[temperatures.length];
        for(int i = temperatures.length -1; i >= 0; i--){
            while(!st.isEmpty()){
                int ind = st.peek();
                if(temperatures[ind] > temperatures[i]){
                    result[i] = ind - i;
                    break;
                }
                else
                    st.pop();
            }
                
            if(st.isEmpty())
                result[i] = 0;

            st.push(i);
        }
        return result;
    }
}