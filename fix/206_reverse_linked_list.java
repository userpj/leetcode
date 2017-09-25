class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode move = head;
        ListNode pre = null;
        while(move != null ) {
            ListNode tmp = move.next;
            move.next = pre;
            pre = move;
            move = tmp;
        }
        return pre;
    }
}
