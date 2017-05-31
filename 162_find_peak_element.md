A peak element is an element that is greater than its neighbors.

Given an input array where `num[i] ≠ num[i+1]`, find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that `num[-1] = num[n] = -∞`.

For example, in array `[1, 2, 3, 1]`, 3 is a peak element and your function should return the index number 2.

### my answer

```java
public class Solution {
	 private int findPeakElement(int[] a, int from, int to) {
		if(to - from == 0) return from;
		if(to - from == 1) return ((a[from] > a[to])? from : to);
		int middle = (to + from) /2;
		int l = findPeakElement(a, middle, to);
		int r = findPeakElement(a, from, middle);
		return ((a[l] < a[r]) ? r: l);
	}
	
	public int findPeakElement(int[] num) {
		return findPeakElement(num, 0, num.length-1);
	}
	
}

```

