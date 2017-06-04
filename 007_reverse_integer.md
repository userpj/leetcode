Reverse digits of an integer.

**Example1:** x = 123, return 321
**Example2:** x = -123, return -321



### my answer

```java
public class Solution {
    public int reverse(int x) {
        int result = 0;
        int flag = 0;
        if(x == -2147483648) return 0;//add2 -2147483648，abs也输出-2147483648
        if(x < 0) { 
        	x = Math.abs(x);
        	flag = 1;
        }
      
        while(x/10 > 0) {
        	result = result*10 +x%10;
        	x = x/10;
        }
      
        int test = Integer.MAX_VALUE;
        if(test/10 < result) return 0; //add1 1534236469 不通过
        if(test/10 == result && x > test%10) return 0; //add1
        result = result*10 + x;

        if(flag == 1) result = -result;
        return result;
    }
}
```

### better answer

```java
public int reverse(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
```

```java
public int reverse(int x)
{
    int result = 0;

    while (x != 0)
    {
        int tail = x % 10;
        int newResult = result * 10 + tail;
        if ((newResult - tail) / 10 != result)
        { return 0; }
        result = newResult;
        x = x / 10;
    }

    return result;
}
```

