You are given a string representing an attendance record for a student. The record only contains the following three characters:

1. **'A'** : Absent.
2. **'L'** : Late.
3. **'P'** : Present.

A student could be rewarded if his attendance record doesn't contain **more than one 'A' (absent)** or **more than two continuous 'L' (late)**.

You need to return whether the student could be rewarded according to his attendance record.

**Example 1:**

```
Input: "PPALLP"
Output: True

```

**Example 2:**

```
Input: "PPALLL"
Output: False
```

### my answer

```java
public class Solution {
    public boolean checkRecord(String s) {
        int a=0, l=0;
        for(int i = 0; i<s.length(); i++) {
          //if == 'A' else if == 'L' is quicker
        	if(s.charAt(i) == 'A') a++;
        	if(s.charAt(i) == 'L') {
        		l++;
        	}else l=0;
        	if(a>1 || l>2) return false;
        }
        return true;
    }
}
```

