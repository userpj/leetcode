Given a string containing just the characters `'('` and `')'`, find the length of the longest valid (well-formed) parentheses substring.

For `"(()"`, the longest valid parentheses substring is `"()"`, which has length = 2.

Another example is `")()())"`, where the longest valid parentheses substring is `"()()"`, which has length = 4.

**解法**

O(n),stack。从第一个'('开始压栈。遇到')'出栈。记录第一个入栈前的编号，当全部出栈，编号差即为此段计算。部分出栈时，当前编号减去出栈编号即此段计算。

```java
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        //Stack<Integer> stack = new Stack<>(); //导致tle
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        int left = -1;
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) == '(') stack.push(i); //将编号压入栈
            else {
                if(stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    if(stack.isEmpty()) max =Math.max(max,i-left); //add: 判断栈为空
                    else max = Math.max(max, i-stack.peek());
                }
            }
        }
        return max;
    }
}
```

**dp**:

If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.

Else if s[i] is ')'

​     If s[i-1] is '(', longest[i] = longest[i-2] + 2

​     Else if s[i-1] is ')' **and s[i-longest[i-1]-1] == '('**, longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.

```java
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for(int i=1; i< len;i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i-1) == '(')  {
                    dp[i]=(i>=2 ? dp[i-2] + 2 : 2);
                }
                else if(i - dp[i-1] - 1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                    //dp[i]=(i-dp[i-1] -2 >= 0 ? dp[i-1] + 2 + dp[i-dp[i-1]-2] : 0);
                    dp[i]=(i-dp[i-1] -2 >= 0 ? dp[i-1] + 2 + dp[i-dp[i-1]-2] : dp[i-1]+2);
                } 
                 max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}
```

事实上，如果s.charAt(i-1)=='（' dp[i-1] == 0;故不需要判断s.charAt(i-1) == '('。

```java
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for(int i=1; i< len;i++) {
            if(s.charAt(i) == ')' && i - dp[i-1] - 1 >= 0 && s.charAt(i-dp[i-1]-1) == '(') {
                dp[i]=(i-dp[i-1] -2 >= 0 ? dp[i-1] + 2 + dp[i-dp[i-1]-2] : dp[i-1]+2);
                max = Math.max(dp[i],max);
            }
        }
        return max;
    }
}
```

