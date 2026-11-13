public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        if (head.val == head.next.val) {
            int duplicateVal = head.val;
            ListNode curr = head;
            
            while (curr != null && curr.val == duplicateVal) {
                curr = curr.next;
            }
            
            return deleteDuplicates(curr);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}