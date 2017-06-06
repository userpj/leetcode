```
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

正则匹配。

a* 匹配0-n个a。.匹配一个字符。

**思路**：动态规划

```java
if p.charAt(j) == s.charAt(i) || p.charAt(j) =='.': dp[i][j] = dp[i-1][j-1]
```

```java
if p.charAt(j) == '*':
	if p.charAt(j-1) ! = s.charAt(i) : dp[i][j] = dp[i][j-2] //s:ac p: ab*c
    if p.charAt(i-1) == s.charAt(i) || p.charAt(i-1) == '.':
		dp[i][j] = dp[i-1][j] //s:aaaaaaaac p:a*c
        || dp[i][j] = dp[i][j-1] //s:ac p:a*c
        || dp[i][j] = dp[i][j-2] //s:ac p:aa*c
```





```java
public class Solution {
    public boolean isMatch(String s, String p) {
       // if(s.isEmpty()) return p.isEmpty(); //s:"" p:".*"
        int lens = s.length(), lenp = p.length();

        boolean[][] dp = new boolean[lens+1][lenp+1];
        dp[0][0] = true;
        
      //处理a*,a*b,a*b*c这样的情况
        for(int i = 0; i<lenp; i++) {
            if(p.charAt(i)=='*' && dp[0][i-1]) dp[0][i+1] = true;
        }
        
        for(int i=0; i<lens; i++) {
            for(int j=0; j<lenp; j++) {
                if(p.charAt(j) == '.' || p.charAt(j)==s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                    continue;
                }
                //else { //存在p.charAt(j) != s.charAt(i) && p.charAt(j) != '.'的情况
                if(p.charAt(j) == '*') {
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1)!='.') dp[i+1][j+1] = dp[i+1][j-1];
                    else dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
        return dp[lens][lenp];
    }
}
```

