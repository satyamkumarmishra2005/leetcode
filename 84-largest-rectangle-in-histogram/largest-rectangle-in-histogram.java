class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        Stack<Integer> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // previous smaller element 
        for(int i = 0 ; i< n ; i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? -1: st.peek();
            st.push(i);
        }
    st.clear(); // reuse the stack

     // next smaller element
     
    for(int i = n-1 ; i>=0; i--){

        while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
            st.pop();
        }

        right[i] = st.isEmpty() ? n: st.peek();
        st.push(i);

    }

    int maxArea = 0;
    for(int i =0; i< n ; i++){
        int width = right[i]-left[i]-1;

        maxArea = Math.max(maxArea, heights[i]* width);

    }

    return maxArea;
    }


}