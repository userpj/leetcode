Given an unsorted integer array, find the first missing positive integer.

For example,
Given `[1,2,0]` return `3`,
and `[3,4,-1,1]` return `2`.

Your algorithm should run in *O*(*n*) time and uses constant space.

### 思路

（1）排序再遍历，或者二分，需要O(nlogn);

（2）从0开始一个一个找，需要O(n^2)

（3）用set遍历一遍，储存，再遍历一个一个找，时间O(n)，空间O(n)



数列要么以1开始，返回后面缺少的数字，否则返回1。故令a[0] = 1, a[1] =2 …..。遍历，如果a[i] != i+1，则i+1是缺少的数字。

```java
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i< n; i++) {
            while(nums[i]>0 && nums[i] - 1< n && nums[nums[i]-1] != nums[i]) swap(nums, i, nums[i]-1);
        }
        for(int i = 0; i<n; i++) {
            if(nums[i] != i+1) return i+1;
        }
        return n+1;
    }
    
    private void swap(int[] nums, int i, int j) {
        if(i!=j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
```

