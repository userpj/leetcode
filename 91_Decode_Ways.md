A message containing letters from `A-Z` is being encoded to numbers using the following mapping:

```
'A' -> 1
'B' -> 2
...
'Z' -> 26

```

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message `"12"`, it could be decoded as `"AB"` (1 2) or `"L"` (12).

The number of ways decoding `"12"` is 2.

### my answer

代码写得稀烂。因为0的问题错了无数次。

```java
public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
    	if(s == null || len == 0) return 0;
        char[] str = s.toCharArray();
        int[] dp = new int[len];
        dp[0] = 1;
        if(str[0]=='0') return 0;
        for(int i = 1; i<len; i++) {
        	//导致100直接输出1。而不执行此行代码。
            //if((str[i-1]=='0'||str[i-1]>'2') && str[i] =='0') return 0;
        	//if(str[i]=='0'||str[i]>'2') System.out.println("one");
         	if(i+1<len &&  (str[i]=='0'||str[i]>'2') && str[i+1]=='0') return 0;
         	if(str[i-1]>'2' && str[i]=='0') return 0;
            if(str[i] == '0') {	
            	if(i >= (len-2)) return dp[i-1];
            	if(i>=2) dp[i-1] = dp[i-2];
                dp[i] = dp[i-1];
                if(i+1 <len) {
                	dp[i+1] = dp[i];
                	i++;
                }
                continue;
            }
            
        	if(str[i-1]> '2' || (str[i-1]=='2' && str[i]> '6')) {
        		dp[i] = dp[i-1];
        	} else {
        		if(i<len-1 && str[i+1] == '0') {
        			dp[i] = dp[i-1];
        			//导致110情况无法执行到dp[2]，最终输出0
        			//i++;
        			continue;
        		}
        		if(i < 2) {
        		    dp[i] = 2;
        		    continue;
        		}
        		dp[i] = dp[i-1] + dp[i-2];
        	}
        }
        //System.out.println(dp[0]);
        //System.out.println(dp[1]);
        //System.out.println(dp[2]);
        return dp[len-1];
    }
}
```

