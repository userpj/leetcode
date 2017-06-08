There are two sorted arrays **nums1** and **nums2** of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

**Example 1:**

```
nums1 = [1, 3]
nums2 = [2]

The median is 2.0

```

**Example 2:**

```
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
```

### my answer

合并两数组，O(m+n)，[Time Limit Exceeded ]

```java
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int i = 0, j = 0, k = 0;
        int[] nums3 = new int[len1+len2];
        while(i<len1 && j < len2) {
        	if(nums1[i] < nums2[j]) {
        		nums3[k++] = nums1[i++];
        	}else if(nums1[i] > nums2[j]) {
        		nums3[k++] = nums2[j++];
        	}else {
        		nums3[k++] = nums1[i++];
        		nums3[k++] = nums2[j++];
        	}
        }
        while(i<len1) nums3[k++] = nums1[i++];
        while(j<len2) nums3[k++] = nums2[j++];
        if((len1+len2)%2 == 1) return (double)nums3[(len1+len2)/2];
        int part1 = nums3[(len1+len2)/2];
        int part2 = nums3[(len1+len2)/2 - 1];
        double result = (part1+part2)/2.0;
        return result;
    }
}
```

### better answer

分治，O(log(m+n))

算法思想：

求合并数组的中位数，即求合并数组的第(m+n+1)/2小的数。

令k = (m+n+1)/2。

如果a[k/2-1]<b[k/2-1]，则a[k/2-1]之前的数全是小于合并数组k/2小的数；

剩k/2的数，考虑a[k/2]~a[k/2+k/4]的数，b[0]~b[k/4]的数。

```java
public class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		int k =  (n + m + 1) /2;
		if((m+n) % 2 != 0 ) return getkth(nums1,0,nums2,0,k);
		return (getkth(nums1, 0, nums2, 0, k) + getkth(nums1, 0, nums2, 0, k+1)) /2.0;
	}
    
	public double getkth(int[] nums1, int start1, int[] nums2, int start2, int k) {
		//nums1被扫描完全，nums2剩下的需全部计入。
		if(start1 > nums1.length - 1) return nums2[start2 + k - 1];
		if(start2 > nums2.length - 1) return nums1[start1 + k - 1];
		//最小值
		if(k == 1) return Math.min(nums1[start1], nums2[start2]);
		
		int mid1 = Integer.MAX_VALUE, mid2=Integer.MAX_VALUE;
        //当start1+k/2-1 >= nums1.length时，num2的k/2个数需全部计入，否则无法达到第k小。
		if(start1 + k/2 - 1 < nums1.length) mid1 = nums1[start1 + k/2 -1];
		if(start2 + k/2 - 1 < nums2.length) mid2 = nums2[start2 + k/2 -1];
		
		if(mid1 < mid2) {
          //k-k/2避免了遗漏，比如k=3，先计算了top1。剩余计算了top2。保证了计算完全。
			return getkth(nums1, start1 + k/2, nums2, start2, k-k/2);
         /*nums1:[1,2] , nums2:[1,2]
          *mid1 = 1, mid2 =1
          *return 1.000
          *剩余数未被计算。
          */
		//} else if (mid1 == mid2){
		//	return (double)mid1;
		}else {
			return getkth(nums1, start1, nums2, start2 + k/2, k-k/2);
		}
	}
}
```

