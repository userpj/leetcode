Given a linked list, remove the *n*th node from the end of list and return its head.

For example,

```
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

```

**Note:**
Given *n* will always be valid.
Try to do this in one pass.



### my answer

```java
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if(n==0) return head;
    	
        ListNode l1 = head;
        ListNode l2 = head;
        ListNode l3 = l2;
        for(int i = 0; i<n-1; i++) {
        	l1 = l1.next;
        	if(l1==null) return null;
        }
        while(l1.next!=null) {
        	l1 = l1.next;
        	l3 = l2;
        	l2 = l2.next;
        }
        //if(l3 == head) return head.next;
        if(l2==head) return head.next;
        l3.next = l2.next;
        return head;     
    }
}
```

