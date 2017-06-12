Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

```java
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return sortedListToBST(head,null);
    }
    
    public TreeNode sortedListToBST(ListNode head, ListNode tail) {
        if(head==tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode node = new TreeNode(slow.val);
        node.left = sortedListToBST(head, slow);
        node.right = sortedListToBST(slow.next, tail);
        return node;
    }
}
```

