Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

**Example 1:**

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

```

**Note:** In the string, each word is separated by single space and there will not be any extra space in the string.

### my answer

```java
public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        int start = 0;
        String str = "";
        for(int i=0; i<len; i++) {
        	if(s.charAt(i)==' ') {
        		str = str + new StringBuilder(s.substring(start, i)).reverse().toString()+ " ";
        		start = i + 1;
        	}
        }
        str = str + new StringBuilder(s.substring(start)).reverse().toString();
        return str;
    }
}
```

### better answer

```java
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse().toString()).append(" ");
        }
        
        return sb.toString().trim();
    }
}
```

