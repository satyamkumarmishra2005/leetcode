class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
    }
}


class MyLinkedList {

        Node head;
        int size;

    public MyLinkedList() {
        size = 0;
        head = null;

        
    }
    
    public int get(int index) {

       if(index<0 || index>=size) {
           return -1;
       }
         
        Node temp = head;

       for(int i =0 ; i< index; i++){
        temp = temp.next;
       }   

       return temp.val;
       
       
       }
        
    
    
    public void addAtHead(int val) {

        Node node1 = new Node(val);

        if(size==0){   // if the linkedlist is empty
            head = node1;
        }

        else{
            node1.next = head;
            head = node1;
        }

        size++;


        
    }
    
    public void addAtTail(int val) {

        Node node1 = new Node(val);

        if(size==0 ){
            head = node1;
        }

        else{
            Node temp = head;

            while(temp.next!= null){
                temp = temp.next;
            }

            temp.next = node1;
        }

        size++;
        
    }
    
    public void addAtIndex(int index, int val) {
        

        if(index<0 || index>size){
            return ;
        }
         Node node1 = new Node(val);

         if(index==0){
            addAtHead(val);
            return ;
         }

         else if(index==size){
            addAtTail(val);
            return;
         }

         else{
            Node temp = head;

            for(int i = 0; i<index-1; i++){
                temp = temp.next;
            }

            node1.next = temp.next;
            temp.next = node1;
            
         }

         size++;
        
    }
    
    public void deleteAtIndex(int index) {
         if(index<0 || index>=size) return;

         if(head!=null && index==0){
            head = head.next;
         }

         else{
            Node temp = head;
                for(int i=0; i<index-1; i++) temp=temp.next;
                temp.next = temp.next.next;

         }
      size--;


    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */