```
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
```



*匹配任何数目任何字符。

```java
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        int lens = s.length(), lenp = p.length();
        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        //if(p.charAt(0) == '*') dp[0][1] = true; //s:"ho" p:"**ho"
        for(int i=0; i<lenp; i++) {
            if(p.charAt(i)!='*') break;
            dp[0][i+1] = true;
        }
        for(int i = 0; i<lens; i++) {
            for(int j=0; j<lenp; j++) {
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') dp[i+1][j+1] = dp[i][j];
                else if(p.charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i+1][j] ||dp[i][j+1];
                }
            }
        }
        return dp[lens][lenp];
    }
}
```

