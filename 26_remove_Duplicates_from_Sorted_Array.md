Given a sorted array, remove the duplicates in place such that each element appear only *once* and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array *nums* = `[1,1,2]`,

Your function should return length = `2`, with the first two elements of *nums* being `1` and `2` respectively. It doesn't matter what you leave beyond the new length.



### my answer

```java
public class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int count = 0;
        for(int i = 0; i<n-1;i++) {
        	if(nums[i+1] > nums[i]) {
        	    nums[count] = nums[i];
        	    count++;
        	}
        }
      //填入最后一个数
        nums[count++] =nums[n-1];
        return count;
    }
}
```

