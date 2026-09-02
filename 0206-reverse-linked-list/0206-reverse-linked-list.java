class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextTemp = current.next; // Save the next node
            current.next = prev;              // Reverse the pointer
            prev = current;                   // Move prev forward
            current = nextTemp;               // Move current forward
        }

        return prev; // prev is the new head of the reversed list
    }
}