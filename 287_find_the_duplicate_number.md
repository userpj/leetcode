Given an array *nums* containing *n* + 1 integers where each integer is between 1 and *n* (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

**Note:**

1. You **must not** modify the array (assume the array is read only).
2. You must use only constant, *O*(1) extra space.
3. Your runtime complexity should be less than `O(n2)`.
4. There is only one duplicate number in the array, but it could be repeated more than once.

长度为n+1的数组，包含数字1~n。求重复的数字，只有一个数字重复，且可以重复多次。

**暴力法** 93ms O(n^2)

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        for(int i = 0; i<nums.length; i++) {
            for(int j = i+1; j<nums.length; j++) {
                if(nums[i]==nums[j]) return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
```

**二分法** 6ms O(nlogn) 先找个mid。如果数组中小于等于mid的数大于mid，则重复的数一定小于等于mid。

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length-1;
        while(start<end) {
            int mid = (start + end)/2;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] <=mid) count++;
            }
            if(count > mid) end = mid;
            else start = mid + 1;
        }
        return start;
    }
}
```



假设数组中没有重复，那我们可以做到这么一点，就是将数组的下标和1到n每一个数一对一的映射起来。比如数组是`213`,则映射关系为`0->2, 1->1, 2->3`。假设这个一对一映射关系是一个函数f(n)，其中n是下标，f(n)是映射到的数。如果我们从下标为0出发，根据这个函数计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推，直到下标超界。实际上可以产生一个类似链表一样的序列。比如在这个例子中有两个下标的序列，`0->2->3`。

但如果有重复的话，这中间就会产生多对一的映射，比如数组`2131`,则映射关系为`0->2, {1，3}->1, 2->3`。这样，我们推演的序列就一定会有环路了，这里下标的序列是`0->2->3->1->1->1->1->...`，而环的起点就是重复的数。

参考142：求链表有环(用n-1开始因为最大为n-2)

```java
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) nums[i]--;
        int slow = n-1;
        int fast = n-1;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) {
                //int slow2 = nums[n-1];
                int slow2 = n-1;
                while(true) {
                    slow2 = nums[slow2];
                    slow = nums[slow];
                    if(slow==slow2) return slow+1;
                }
            }
        }
    }
}
```



```java
public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums.length;
        int slow = nums.length;
        do {
            fast = nums[nums[fast - 1] - 1];
            slow = nums[slow - 1];
        } while(fast != slow);
        fast = nums.length;
        while (slow != fast) {
            fast = nums[fast - 1];
            slow = nums[slow - 1];
        }
        return slow;
    }
}
```

