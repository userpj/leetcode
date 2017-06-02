Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only *distinct* numbers from the original list.

For example,
Given `1->2->3->3->4->4->5`, return `1->2->5`.
Given `1->1->1->2->3`, return `2->3`.

### my answer

```java
 /**
 *又是很烂的代码。
 *有些重复逻辑。
 *先执行pre2 = new ListNode(0)应该更好。
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head ==null || head.next==null) return head;
        while(head.next!=null && head.next.val==head.val) {
        	int tmp = head.val;
        	if(head.next.val==tmp) {
        		while(head.val==tmp) {
        		    if(head.next==null) return null;
        		    head=head.next;
        		}
        	}
        }
        ListNode pre = head;
        ListNode pre2 = new ListNode(0);
        pre2.next =pre;
        while(pre.next!=null) {
        	int tmp = pre.val;
        	if(pre.next.val==tmp) {
        		while(pre.val==tmp) {
        			pre2.next = pre.next;
        			if(pre.next==null) return head;
        			pre =pre.next;
        		}
        	}else {
        	    pre = pre.next;
        	    pre2 = pre2.next;
        	}
        }
        return head;
    }
}
```

