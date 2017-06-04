Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

**思路**

栈最典型的应用就是验证配对情况，作为有效的括号，有一个右括号就必定有一个左括号在前面，所以我们可以将左括号都push进栈中，遇到右括号的时候再pop来消掉。这里不用担心连续不同种类左括号的问题，因为有效的括号对最终还是会有紧邻的括号对。如栈中是({[，来一个]变成({，再来一个}，变成(。

```java
public class Solution {
    public boolean isValid(String s) {
    	Stack<Character> stk = new Stack<>();
    	int len = s.length();
    	for(int i = 0; i < len; i++) {
    		char c = s.charAt(i);
    		
    		if(c == '(')  stk.push(')');
    		else if(c == '[') stk.push(']');	
    		else if(c == '{') stk.push('}');
    		else if(stk.isEmpty() || stk.pop() != c) return false;	
    	}
    	//return true;
    	return stk.isEmpty();
    }
}
```

数组模拟栈；

```java
public class Solution {
    public boolean isValid(String s) {
        
        int l = s.length();
        char[] parens = s.toCharArray();
        int i = -1;
        
        for (int ci = 0; ci < l; ci++) {
          char c = parens[ci];
          
          switch (c) {
            case '(':
            case '{':
            case '[':
              parens[++i] = c;
              break;
            case ')':
              if (i < 0 || parens[i--] != '(') return false;
              break;
            case '}':
              if (i < 0 || parens[i--] != '{') return false;
              break;
            case ']':
              if (i < 0 || parens[i--] != '[') return false;
              break;
            default:
              break;
            }
            
        }
        return i == -1;
    }
}
```

