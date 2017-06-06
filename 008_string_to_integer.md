Implement atoi to convert a string to an integer.

**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.



```java
public class Solution {
    public int myAtoi(String str) {
        int len = str.length();
        if(len == 0 || str == null) return 0;
        int index =0, sign = 1;
        int result = 0;
        int plus = 0;
        
      //去除空格
        while(str.charAt(index) == ' ') index++;
        if(index>=len) return 0;
        
      //符号处理。 +-12返回0
        if(str.charAt(index) == '+' ) {
            plus = 1;
            index++;
        }
        if(index>=len) return 0;
        
        if(str.charAt(index) == '-') {
            if(plus==1) return 0;
            sign = -1;
            index++;
        }
        
      //计算。213123jksfkf 返回213123
        while(index < len) {
            int num = str.charAt(index) - '0';
            //if(num>9 || num <0) return 0;
            if(num>9 || num <0) break;
          //判断溢出、溢出返回最大值。
            if(result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10))  return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result*10 + num;
            index++;
        }
        return result * sign;
    }
}
```

