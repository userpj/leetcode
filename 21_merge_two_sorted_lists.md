Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

### my solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = null;
        
        if(l1.val < l2.val) {
        	head = l1;
        	l1 = l1.next;
        }else {
        	head = l2;
        	l2 = l2.next;
        }
        ListNode result = head;
        while(l1!=null && l2!=null) {
        	if(l1.val < l2.val) {
        		head.next = l1;
        		l1= l1.next;
        		head = head.next;
        	}else {
        		 head.next = l2;
        		 l2 = l2.next;
        		 head = head.next;
        	}
        }
        
        while(l1!=null) {
        	head.next = l1;
        	head = head.next;
        	l1 = l1.next;
        }
        
        while(l2!=null) {
        	head.next = l2;
        	head = head.next;
        	l2 = l2.next;
        }
        
       return result;
        
    }
}
```



### better answer

```java
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode s1;
        if(l1.val < l2.val)
        {
            s1 = l1;
            s1.next = mergeTwoLists(l1.next, l2 );
        }
        else {
            s1 = l2;
            s1.next = mergeTwoLists(l1, l2.next);
        }
        
        return s1;
    }
}
```

