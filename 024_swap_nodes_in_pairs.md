Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given `1->2->3->4`, you should return the list as `2->1->4->3`.

Your algorithm should use only constant space. You may **not** modify the values in the list, only nodes itself can be changed.



```java
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next ==null) return head;
        ListNode node1 = head;
        ListNode node2 = head.next;
        head = node2;
        ListNode pre = new ListNode(0);
        pre.next = node1;
        while(node2!=null) {
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;
            if(node1.next == null || node1.next.next == null) break;
            pre = node1;
            node2 = node1.next.next;
            node1 = node1.next;
        }
        return head;
    }
}
```

recursion:

```java
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
```

