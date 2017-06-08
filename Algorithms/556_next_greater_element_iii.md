Given a positive **32-bit** integer **n**, you need to find the smallest **32-bit** integer which has exactly the same digits existing in the integer **n** and is greater in value than n. If no such positive **32-bit** integer exists, you need to return -1.

**Example 1:**

```
Input: 12
Output: 21

```

**Example 2:**

```
Input: 21
Output: -1
```

### my answer

```java
public class Solution {
    public int nextGreaterElement(int n) {
    	String str = Integer.toString(n);
        int len = str.length();
        for(int i=len-1; i>0;i--) {
        	if(str.charAt(i)> str.charAt(i-1)) {
        		int smallest = i;
        		//to find the smallest number bigger than n[i-1];
        		for(int j=i+1;j<len;j++) {
        			if(str.charAt(j)>str.charAt(i-1)) smallest = j;
        		}
        		//substring(0,1).equals(charAt(0)), reverse to make sure the rest is a smallest number.
        		String str2 = str.substring(0,  i-1) + str.charAt(smallest) + new StringBuilder(str.substring(i,smallest)+ str.charAt(i-1)+str.substring(smallest+1)).reverse().toString();
        		try {
        			return Integer.parseInt(str2);
        		}catch(Exception e) {
        			return -1;
        		}
        	}
        }
        return -1;
    }
}
```



