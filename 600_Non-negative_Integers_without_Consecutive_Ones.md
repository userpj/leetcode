Given a positive integer n, find the number of **non-negative** integers less than or equal to n, whose binary representations do NOT contain **consecutive ones**.

**Example 1:**

```
Input: 5
Output: 5
Explanation: 
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 

```

**Note:** 1 <= n <= 109



### my answer

```java
public class Solution {
    public int findIntegers(int num) { 
        //we need reverse. to make higher position has a higher number.
    	StringBuilder str = new StringBuilder(Integer.toBinaryString(num)).reverse();
    	int n = str.length();
    	int[] a = new int[n];
    	int[] b = new int[n];
    	a[0] = b[0] = 1;
    	for(int i=1; i<n; i++) {
    		//ai means strings end in 0;bi means end in 1。for no 11,so b[i] = a[i-1]
    		a[i] = a[i-1] + b[i-1];
    		b[i] = a[i-1];
    	}
    	int result = a[n-1] + b[n-1];
    	for(int i=n-2; i>=0; i--) {
    		//no smaller number
    		if(str.charAt(i) == '1' && str.charAt(i+1) == '1') break;
    		//01 is bigger than 00;
    		//100 => 110,break; 000 => 010;
    		if(str.charAt(i) == '0' && str.charAt(i+1) == '0') result -= b[i];
    	}
    	return result;
    }
}
```

