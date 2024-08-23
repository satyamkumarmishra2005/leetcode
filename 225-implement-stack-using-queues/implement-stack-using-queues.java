class MyStack {
private Queue<Integer> queque;
    public MyStack() {
        queque = new LinkedList<>();
    }
    
    public void push(int x) {
        queque.add(x);
        for(int i = 1; i<queque.size(); i++){
            queque.add(queque.remove());
        }
    }
    
    public int pop() {
        return queque.remove();
    }
    
    public int top() {
        return queque.peek();
    }
    
    public boolean empty() {
        return queque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */