/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public int lengthcycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!= null && fast!= null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                ListNode temp = slow;
            int length = 0;

            do{
                temp = temp.next;
                length++;
            }while(temp!= slow);
            return length;
            }

        }
        return 0;
    }


    public ListNode detectCycle(ListNode head) {
        int length = 0;
         ListNode fast = head;
        ListNode slow = head;

        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
            length = lengthcycle(slow);
            break;
    }

}

if(length==0){
    return null;
}

// find the start
ListNode f = head;
ListNode s = head;

while(length>0){
    s = s.next;
    length--;
}
// keep moving both forward till they meet at start of the cycle
while(f!= s){
    f = f.next;
    s = s.next;
}
return s;

    }
}