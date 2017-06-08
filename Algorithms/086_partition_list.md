Given a linked list and a value *x*, partition it such that all nodes less than *x* come before nodes greater than or equal to *x*.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given `1->4->3->2->5->2` and *x* = 3,
return `1->2->2->4->3->5`.

题意：给定数字x。将链表中小于x的放左边，大于等于x的放右边。尽量不改变原顺序。

做法：遍历到第一个大于等于x的数字，然后将其后面的所有小于x的数字插入其前面一位。

```java
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode big = head;//找到的第一个大于等于x的节点
        ListNode small = head;//找到的big后小于x的节点
        ListNode pre1 = new ListNode(0); //big的前置节点
        ListNode pre2 = new ListNode(0);//small的前置节点
        pre1.next =head;
        ListNode newhead = pre1;//head前置节点
        
        while(big !=null && big.val < x) {
            pre1 = pre1.next;
            big = big.next;
        }
        if(big==null||big.next==null) return head;
        small =big;
        pre2 = pre1;
        while(small!=null) {
            if(small.val<x) {
                pre2.next = small.next;
                small.next = big;
                pre1.next = small;
                pre1 = pre1.next;
                small = pre2.next;
            }else {
                pre2=pre2.next;
                small = small.next;
            }
        }
        return newhead.next;
    }
}
```

### better

```java
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesshead = new ListNode(0);
        ListNode biggerhead = new ListNode(0);
        
        ListNode less = lesshead, bigger = biggerhead;
        while(head!=null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else{
                bigger.next = head;
                bigger = bigger.next;
            }
            
            head = head.next;
        }
        
        less.next = biggerhead.next;
        bigger.next = null;
        head = lesshead.next;
        return head;
    }
}
```

