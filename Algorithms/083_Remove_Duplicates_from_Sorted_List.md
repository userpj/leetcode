Given a sorted linked list, delete all duplicates such that each element appear only *once*.

For example,
Given `1->1->2`, return `1->2`.
Given `1->1->2->3->3`, return `1->2->3`.

### my answer

```java
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
        ListNode forward = head.next;
        ListNode behind = head;
      //没注意是排序好的，不需要set。
        Set<Integer> set = new HashSet<>();
        set.add(behind.val);
        //while(forward.next!=null) {
        while(forward!=null) {
        	if(set.contains(forward.val)) {
        		behind.next = forward.next;
        	}else {
        		set.add(forward.val);
        		behind = behind.next;
        	}
        	forward = forward.next;
        }
        return head;
    }
}
```

