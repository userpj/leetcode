Write a program to find the `n`-th ugly number.

Ugly numbers are positive numbers whose prime factors only include `2, 3, 5`. For example, `1, 2, 3, 4, 5, 6, 8, 9, 10, 12` is the sequence of the first `10` ugly numbers.

Note that `1` is typically treated as an ugly number, and *n* **does not exceed 1690**.

### my answer

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …

```java
public class Solution {
    public int nthUglyNumber(int n) {
    	int[] ugly = new int[1690];
    	ugly[0] = 1;
    	int index2=0, index3=0, index5=0;
    	for(int i = 0; i < n-1;i++) {
    		int ugly2 = 2*ugly[index2], ugly3 = 3*ugly[index3], ugly5 = 5*ugly[index5];
    		ugly[i+1] = Math.min(ugly2,Math.min(ugly3,ugly5));
          //不用if else。保证不重复增加。比如2*3 = 3*2
    		if(ugly[i+1] == ugly2) index2++;
    		if(ugly[i+1] == ugly3) index3++;
    		if(ugly[i+1] == ugly5) index5++;
    	}
    	return ugly[n-1];
    }
}
```

