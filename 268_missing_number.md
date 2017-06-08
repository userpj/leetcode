Given an array containing *n* distinct numbers taken from `0, 1, 2, ..., n`, find the one that is missing from the array.

For example,
Given *nums* = `[0, 1, 3]` return `2`.

**Note**:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?



(1)由题意，大小为n的数组里的所有数都是0 - n之间的数，作为等差数列，如果没有缺失的时候它的和是能O(1)计算出来的，所以我们遍历一遍记录最大、最小和数组和，用期望数组和减去实际数组和，就是缺失的整数

```java
public class Solution {
    public int missingNumber(int[] nums) {
        int sum=0, min=Integer.MAX_VALUE, max=0;
        
        for(int i=0; i< nums.length; i++) {
            sum += nums[i];
            if(nums[i]>max) max = nums[i];
            if(nums[i]<min) min = nums[i];
        }
        
        if(min != 0) return 0;
        if(max == 0) return 1;
        int realsum = (min+max)*(max-min+1)/2;
        int verse = realsum -sum;
        
        return (verse == 0) ? max+1 : verse;
    }
}
```

(2)根据异或的特性，对于一个数，异或自己是0，异或0是自己，所以我们把0-n都异或一遍，再对着给定数组异或一遍，结果就是缺失的数。

```java
public int missingNumber(int[] nums) { //xor
    int res = nums.length;
    for(int i=0; i<nums.length; i++){
        res ^= i;
        res ^= nums[i];
    }
    return res;
}
```

