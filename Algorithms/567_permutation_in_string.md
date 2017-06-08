Given two strings **s1** and **s2**, write a function to return true if **s2** contains the permutation of **s1**. In other words, one of the first string's permutations is the **substring** of the second string.

**Example 1:**

```
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").

```

**Example 2:**

```
Input:s1= "ab" s2 = "eidboaoo"
Output: False
```



### my answer

```java
public class Solution {
	public boolean checkInclusion(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		if(l1 > l2) return false;
		int[] alpha = new int[26];
		
		for(int i=0; i<l1; i++) {
			alpha[s1.charAt(i)-'a']++;
			alpha[s2.charAt(i)-'a']--;
		}
		
		if(Allzero(alpha)) return true;
		
		for(int i=l1; i<l2; i++) {
			alpha[s2.charAt(i)-'a']--;
			alpha[s2.charAt(i-l1)-'a']++;
			if(Allzero(alpha)) return true;
		}
		return false;
	}
	
	private boolean Allzero(int[] array) {
		for(int i=0; i<array.length;i++) {
			if(array[i] != 0) return false;
		}
		return true;
	}
}
```

