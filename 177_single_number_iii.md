Given an array of numbers `nums`, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given `nums = [1, 2, 1, 3, 2, 5]`, return `[3, 5]`.

**Note**:

1. The order of the result is not important. So in the above example, `[5, 3]` is also correct.
2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?



```java
public class Solution {
  //求两个数异或的结果。比如[5,3]
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            result ^= nums[i];
        }
        
        /*
        int tmp = 1; //001
        for(int i = 0; i<32; i++) {
            result >>= i;
            if((result&1) == 1) {
                tmp <<= i;
                break;
            }
        }
        */
      //两个不同的数必然有位不同的位，找到这样的位。
        result &= -result;
        int tmp =result;
      
       //用这位的数和其他所有数相与，结果为0中必然包含其中一个和其他成对的数，结果不为0中也这样。
        for(int i= 0; i<nums.length; i++) {
            if((nums[i] & tmp) == 0) res[0]^=nums[i]; //不能为1
            else res[1]^=nums[i];
        }
        return res;
    }
}
```

