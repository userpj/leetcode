Given an array of integers, every element appears *three* times except for one, which appears exactly once. Find that single one.

**Note:**
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

我们可以建立一个32位的数字，来统计每一位上1出现的个数，我们知道如果某一位上为1的话，那么如果该整数出现了三次，对3去余为0，我们把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字。

```java
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i<32; i++) {
            int sum = 0;
            for(int j = 0; j < nums.length; j++) {
                sum += (nums[j] >> i) & 1;
            }
            res |= (sum%3) << i;
        }
        return res;
    }
}
```

