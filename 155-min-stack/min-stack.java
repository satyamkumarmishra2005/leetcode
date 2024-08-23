class MinStack {
private Node head;
    public MinStack() {
        
    }
    
    public void push(int X) {
        if(head == null){
            head = new Node(X,X,null);
        }
        else{
            head = new Node(X, Math.min(X,head.min),head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }

    private class Node{
        int val;
        int min;
        Node next;

private Node(int val , int min , Node next){
    this.val = val;
    this.min = min ;
    this.next = next;
}
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