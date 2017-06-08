Merge *k* sorted linked lists and return it as one sorted list. Analyze and describe its complexity.



### my answer

分治。

两两合并。

```java
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        //if(lists.length == 1) return lists;
        if(lists.length == 1) return lists[0];
        return mergelists(lists, 0, lists.length-1);
    }
    
    //public ListNode mergelists(ListNode lists,int start, int end) {
    public ListNode mergelists(ListNode[] lists,int start, int end) {
    	if(start == end) return lists[start];
    	if(start > end) return null;
    	int mid = (start + end) /2;
    	ListNode l1 = mergelists(lists, start, mid);
    	ListNode l2 = mergelists(lists, mid+1, end);
    	return merge2list(l1,l2);
    }
    
    public ListNode merge2list(ListNode l1,ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	ListNode p = new ListNode(0);
    	ListNode head = p;
    	while(l1!=null && l2 != null) {
    		if(l1.val < l2.val) {
    			p.next = l1;
    			p = p.next;
    			l1 = l1.next;
    		} else {
    			p.next = l2;
    			p = p.next;
    			l2 = l2.next;
    		}
    	}
    	if(l1!=null) p.next = l1;
    	if(l2!=null) p.next = l2;
    	//return head;
    	return head.next;
    }
}
```

