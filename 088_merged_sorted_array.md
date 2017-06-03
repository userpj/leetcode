Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.

**Note:**
You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*. The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.

### my answer

```java
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, pi = 0;
        /*
        while(j <n) {
            //判断nums2大于nums1所有数的情况
            
            if(pi>=n-1) {
                nums1[i++] = nums2[j++];
                continue;
            }
            */
        while(j <n && pi <m) {
        	if(nums1[i] <= nums2[j]) {
        		i++;
        		pi++;
        	} else {
        		for(int k = m-1+j ; k>=i;k--) nums1[k+1] = nums1[k];
        		//nums1[i] = nums2[j++];
        		nums1[i++] = nums2[j++];
        	}	
        }
        while(j<n) {
            nums1[i++] = nums2[j++];
        }
    }
}
```

### better answer

题目告知

```java
public void merge(int A[], int m, int B[], int n) {
    int i=m-1, j=n-1, k=m+n-1;
    while (i>-1 && j>-1) A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
    while (j>-1)         A[k--]=B[j--];
}
```

```java
while(n>0)A[m+n-1]=(m==0||B[n-1]>A[m-1])?B[--n]:A[--m];
```

