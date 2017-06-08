You are given two **non-empty** linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Follow up:**
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

**Example:**

```
Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
```



利用数据结构栈，把l1和l2分别压入不同的栈。避免了reverse链表。

```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        if(l1.val==0 && l2.val ==0) return l1;
        
        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry=0;
        ListNode list = new ListNode(0);
        while(!stack2.isEmpty() || !stack1.isEmpty()) {
            int sum = (stack1.isEmpty()? 0 : stack1.pop()) + (stack2.isEmpty()? 0 : stack2.pop()) + carry;
            carry = sum/10;
            list.val = sum%10;
            ListNode tmp = new ListNode(0);
            tmp.next = list;
            list = tmp;
        }
        
        if(carry != 0) list.val = carry;
        while(list.val == 0) list = list.next;
        return list;
    }
}
```



```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rL1 = reverse(l1);
        ListNode rL2 = reverse(l2);
        
        int c = 0;
        ListNode resHead = new ListNode(0);
        ListNode resTail = resHead;
        while(rL1 != null || rL2 != null) {
            int sum = c;
            if(rL1 != null) {
                sum += rL1.val;
                rL1 = rL1.next;
            }
            
            if(rL2 != null) {
                sum += rL2.val;
                rL2 = rL2.next;
            }
            c = sum / 10;
            ListNode node = new ListNode(sum % 10);
            resTail.next = node;
            resTail = node;
        }
        
        if(c > 0) {
            resTail.next = new ListNode(c);
        }
        
        return reverse(resHead.next);
    }
    
    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        
        while(head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead = cur;
        }
        
        return newHead;
    }
}
```

