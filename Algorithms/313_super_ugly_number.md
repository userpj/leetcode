Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list `primes` of size `k`. For example, `[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] `is the sequence of the first 12 super ugly numbers given `primes` = `[2, 7, 13, 19]` of size 4.

**Note:**
(1) `1` is a super ugly number for any given `primes`.
(2) The given numbers in `primes` are in ascending order.
(3) 0 < `k` ≤ 100, 0 < `n` ≤ 106, 0 < `primes[i]` < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

### my answer

```java
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len=primes.length;
        int[] ugly = new int[n];
        int[] prim = new int[len]; //记录primes[j]的个数。
        ugly[0] = 1;
        for(int i = 0; i < n-1; i++) {
        	int min = Integer.MAX_VALUE;
        	for(int j = 0; j < len; j++) {
        		int tmp =  ugly[prim[j]] * primes[j];
              //error: min < tmp
        		if(min > tmp) min = tmp;
        	}
        	for(int j = 0; j <len; j++) {
        		if(min == ugly[prim[j]] * primes[j]) prim[j]++;
        	}
        	ugly[i+1] = min;
        }
        return ugly[n-1];
    }
}
```



heap

```java
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution {
public int nthSuperUglyNumber(int n, int[] primes) {
	Comparator<Number> comparator = new NumberCompare();
	PriorityQueue<Number> queue = 
            new PriorityQueue<Number>(primes.length, comparator);
	for(int i = 0; i < primes.length; i ++) 
		queue.add(new Number(primes[i], 0, primes[i]));
	int[] uglyNums = new int[n];
	uglyNums[0] = 1;
	for(int i = 1; i < n; i++){
		Number min = queue.peek();
		uglyNums[i] = min.un;
		while(queue.peek().un == min.un){
			Number tmp = queue.poll();
			queue.add(new Number(uglyNums[tmp.pos + 1] * tmp.prime, tmp.pos+1, tmp.prime)); 
		}
	}
	
	return uglyNums[n-1];
}

public class Number{
	int un;
	int pos;
	int prime;
	Number(int un, int pos, int prime){
		this.un = un;
		this.pos = pos;
		this.prime = prime;
	}
}

public class NumberCompare implements Comparator<Number>{

	@Override
	public int compare(Number x, Number y) {
		// TODO Auto-generated method stub
		if (x.un > y.un)
			return 1;
		else if (x.un < y.un)
			return -1;
		else
			return 0;
	}
}
}


```

