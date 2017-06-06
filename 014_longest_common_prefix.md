Write a function to find the longest common prefix string amongst an array of strings.



```java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int num = strs.length;
        //if(num == 0) return null;
        if(num == 0) return "";
        String cmp = strs[0];
        for(int i = 1; i<num; i++) {
            int j = 0;
            for(; j < Math.min(strs[i].length(), cmp.length());) {
                if(strs[i].charAt(j) == cmp.charAt(j)) j++;
                else break;
            }
            cmp = cmp.substring(0,j);
        }
        return cmp;
    }
}
```

