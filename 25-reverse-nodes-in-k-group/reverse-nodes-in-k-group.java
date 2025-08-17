/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevlast = null;
      

      while(temp!= null){
        ListNode kthnode = getkthnode(temp , k);

        if( kthnode == null){
            if(prevlast!= null){
                prevlast.next = temp;

            }

            break;
        }

        ListNode nextnode = kthnode.next;
        kthnode.next = null;

        reverselinkedlist(temp);

        if(temp== head){
            head= kthnode;
        }

        else{
            prevlast.next = kthnode;
        }

        prevlast = temp;
        temp = nextnode;
      }
        return head;
    }


    static ListNode getkthnode(ListNode temp , int k){
        k= k-1;

        while(temp!= null && k > 0){
            temp = temp.next;
            k--;
        }

        return temp;
    }
  static ListNode reverselinkedlist(ListNode head){
    ListNode pres = head;
    ListNode prev = null;
     ListNode next = pres.next;

     while(pres!= null){
        pres.next = prev;
        prev= pres;
        pres = next;

        if(next!= null){
            next = next.next;
        }
     }

     return prev ; // head;
  }

    
}