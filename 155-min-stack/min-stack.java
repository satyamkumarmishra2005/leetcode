class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minstack;

    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    public void push(int val) {

        stack.push(val);

        if(minstack.isEmpty() || val<=minstack.peek()){
            minstack.push(val);
        }
        
    }
    
    public void pop() {
       int poppedval = stack.pop();

       if(poppedval==minstack.peek()){
        minstack.pop();
       }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */