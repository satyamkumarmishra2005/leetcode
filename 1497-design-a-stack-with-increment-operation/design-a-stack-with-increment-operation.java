class CustomStack {
    private List<Integer> st;         // Stack to hold the elements
    private List<Integer> increments; // To hold the increment values
    private int maxSize;              // Maximum size of the stack

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        st = new ArrayList<>();
        increments = new ArrayList<>();
    }
    
    public void push(int x) {
        if (st.size() < maxSize) {
            st.add(x);
            increments.add(0); // Initialize increment for the new element
        }
    }
    
    public int pop() {
        if (st.size() == 0) {
            return -1; // Stack is empty
        }

        int idx = st.size() - 1; // Top element index
        
        // Carry over the increment to the previous element
        if (idx > 0) {
            increments.set(idx - 1, increments.get(idx - 1) + increments.get(idx));
        }

        int topVal = st.get(idx) + increments.get(idx); // Get the value of the top element
        st.remove(idx); // Pop the top element
        increments.remove(idx); // Remove the corresponding increment
        
        return topVal; // Return the popped value
    }
    
    public void increment(int k, int val) {
        int idx = Math.min(k, st.size()) - 1; // Get the correct index
        if (idx >= 0) {
            increments.set(idx, increments.get(idx) + val); // Increment the bottom k elements
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */