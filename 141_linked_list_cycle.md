Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?



```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        //while(head.next != null && head.next.next != null) { //需持续判断next是否为空
        //while(slow.next != null && fast.next.next!=null) {
      /*可以写while(slow.next != null && fast.next != null && fast.next.next!=null)
      	但是fast比slow快，如果fast.next!=null必然有slow.next!=null
      */
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    } 
}
```

