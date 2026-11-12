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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = getLength(head);
        int minSize = count / k;
        int remainder = count % k;

        ListNode[] result = new ListNode[k];
        ListNode pointer = head;

        for (int idx = 0; idx < k && pointer != null; idx++) {
            result[idx] = pointer;
            int chunkSize = minSize + (idx < remainder ? 1 : 0);

            for (int j = 1; j < chunkSize; j++) {
                pointer = pointer.next;
            }

            ListNode nextSegment = pointer.next;
            pointer.next = null;
            pointer = nextSegment;
        }

        return result;
    }

    private int getLength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}