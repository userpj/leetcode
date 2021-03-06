Given a linked list, return the node where the cycle begins. If there is no cycle, return `null`.

**Note:** Do not modify the linked list.

**Follow up**:
Can you solve it without using extra space?



```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                ListNode slowstart = head;
                while(fast != slowstart) {
                    fast = fast.next;
                    slowstart = slowstart.next;
                }
                return slowstart;
            }
        }
        return null;
    }
}
```

Cycle = length of the cycle, if exists.
C is the beginning of Cycle, S is the distance of slow pointer from C when slow pointer meets fast pointer.

Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). To let slow poiner meets fast pointer, only if fast pointer run 1 cycle more than slow pointer. Distance(fast) - Distance(slow) = Cycle
=> 2 * (C + S) - (C + S)	= Cycle
=>	C + S = Cycle
=>	C = Cycle - S
=> This means if slow pointer runs (Cycle - S) more, it will reaches C. So at this time, if there's another point2 running from head
=> After C distance, point2 will meet slow pointer at C, where is the beginning of the cycle.