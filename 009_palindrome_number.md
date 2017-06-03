Determine whether an integer is a palindrome. Do this without extra space.

回文数

### my answer

```java
public class Solution {
    public boolean isPalindrome(int x) {
        //x should be positive
        if(x<0) return false;
        //when x == 0
        if(x == 0) return true;
    	if(x%10 == 0) return false;
        int c = x;
        int result = 0;
        while(x/10 != 0) {
        	result = result*10 + x%10;
        	x = x/10;
        }
        result = result *10 + x;
        return result == c;
    }
}
```

