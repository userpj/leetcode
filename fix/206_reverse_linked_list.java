class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode move = head;
        ListNode pre = null;
        while(move != null && move.next != null) {
            ListNode tmp = move.next;
            move.next = pre;
            pre = move;
            move = tmp;
        }
        if(move != null) move.next = pre;
        return move;
    }
}
