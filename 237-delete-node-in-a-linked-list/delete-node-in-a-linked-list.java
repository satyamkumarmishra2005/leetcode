/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */


//  \U0001f914 Intuition
// We know that previous node pointer to given node. What if we change given node value to next nodes and point next to next.next. It's essentially changing current node to next and deleting next.

// \U0001f9e0 Approach
// To delete the given node, we copy the value of the next node to the current node and adjust the next pointer to skip the next node.

// Copy the value of the next node to the current node.
// Adjust the next pointer to skip the next node.
class Solution {
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next= node.next.next;
    }
}