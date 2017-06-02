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

1.合并两数组，O(m+n)，[Time Limit Exceeded ]

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

