Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = `[2,3,1,1,4]`, return `true`.

A = `[3,2,1,0,4]`, return `false`.



仿造第45题写。

```java
public class Solution {
    public boolean canJump(int[] nums) {
        int next = 0, farest = 0;
        for(int i = 0; i<nums.length; i++) {
            farest = Math.max(farest, nums[i]+i);
            if(i == next)  next = farest;
            else if(i>next) return false;
            
        }
        return true;
    }
}
```



更简单的做法

```java
bool canJump(int A[], int n) {
    int last=n-1,i,j;
    for(i=n-2;i>=0;i--){
        if(i+A[i]>=last)last=i;
    }
    return last<=0;
}
```

