class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode left = head;

        while (true) {

            // Step 1: find right (kth node)
            ListNode right = left;
            for (int i = 1; i < k && right != null; i++) {
                right = right.next;
            }

            // if less than k nodes
            if (right == null) break;

            // Step 2: store next group start
            ListNode secondleft = right.next;

            // Step 3: reverse from left to right
            ListNode curr = left;
            ListNode prevNode = secondleft;

            while (curr != secondleft) {
                ListNode temp = curr.next;
                curr.next = prevNode;
                prevNode = curr;
                curr = temp;
            }

            // Step 4: connect
            prev.next = right;
            prev = left;
            left = secondleft;
        }

        return dummy.next;
    }
}

