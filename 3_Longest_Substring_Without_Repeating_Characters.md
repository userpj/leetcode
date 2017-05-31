### 题目

Given a string, find the length of the **longest substring** without repeating characters.

**Examples:**

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer must be a **substring**, `"pwke"` is a *subsequence* and not a substring.



###  My Answer

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0; i<s.length(); i++) {
        	int count = 0;
        	for(int j=i;j<s.length();j++) {
        		if(set.contains(s.charAt(j))) {
        			set = new HashSet<>();
        			break;
        		}
        		set.add(s.charAt(j));
        		count++;
        		max = Math.max(count, max);
        	}
        }
        return max;
    }
}
```

### better Answer

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
       int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        //不需要两重循环
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, set.size()); //直接用set.size()返回字符串长度。不需要count；
            } else {
              //直接跳到s[i] != s[j]的字符。因为有重复字符的情况，之前的字符的count必然小于max。。
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return max;
    }
}
```



