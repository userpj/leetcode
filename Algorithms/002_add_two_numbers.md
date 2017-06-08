You are given two **non-empty** linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

**Input:** (2 -> 4 -> 3) + (5 -> 6 -> 4)
**Output:** 7 -> 0 -> 8



### my answer

很多重复代码。写得很烂。

```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	ListNode head = new ListNode(0);
    	ListNode calc = head;
    	int carry = 0;
    	int sum;
    	while(l1!=null && l2!=null) {
    		sum = l1.val + l2.val+ carry;
    		calc.val = sum % 10;
    		carry = sum/10;
    		l1=l1.next;
    		l2=l2.next;
    		if(l1==null && l2==null) {
    			if(carry==0) return head;
    			calc.next=new ListNode(carry);
    			calc = calc.next;
    			return head;
    		} 
    		calc.next =new ListNode(carry);
    		calc=calc.next;
    	}
    	while(l1!=null) {
    		sum = l1.val+carry;
    		calc.val = sum%10;
    		carry = sum/10;
			l1 = l1.next;
    		if(l1==null) {
    			if(carry==0) return head;
    			calc.next=new ListNode(carry);
    			calc.next.val=carry;
    			return head;
    		} 
			calc.next=new ListNode(carry);
			calc = calc.next;
    	}
    	while(l2!=null) {
    		sum = l2.val+carry;
    		calc.val = sum%10;
    		carry = sum/10;
    		l2 = l2.next;
    		if(l2==null) {
    			if(carry==0) return head;
    			calc.next=new ListNode(carry);
    			calc.next.val=carry;
    			return head;
    		} 
    		calc.next = new ListNode(carry);
    		calc=calc.next;
    	}
    	return head;
    }
}
```

### better answer

```java
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
}
```

