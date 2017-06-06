Given a linked list, reverse the nodes of a linked list *k* at a time and return its modified list.

*k* is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of *k* then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: `1->2->3->4->5`

For *k* = 2, you should return: `2->1->4->3->5`

For *k* = 3, you should return: `3->2->1->4->5`

ac得好突然。。。

```java
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode mid = new ListNode(0);
        mid.next = head;
        ListNode node1 = head;
        ListNode nodek = head;
        int i = 1;
      //计算最后一个需要reverse的node的位置。
        while(i<k) {
            nodek = nodek.next;
            if(nodek == null) return head;
            i++;
        }

        mid = node1.next;
        node1.next = reverseKGroup(nodek.next, k);
        ListNode node2 = mid.next;
        
        i = 1;
        while(i<k) {
            mid.next = node1;
            if(node2 == null) return mid;
            node1 = mid;
            mid = node2;
            node2 = node2.next;
            i++;
        }
        return node1;
    }
}
```

