Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example:**

```
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

```

**Example:**

```
Input: "cbbd"

Output: "bb"
```



O(n^2) 91ms

```java
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0 || n== 1) return s;
        int result = 1;
        String max = "";
        for(int i=0; i<n; i++) {
            int start = i, end =i;
            while((end+1) < n && s.charAt(end) == s.charAt(end+1)) end++;
            while(start>0 && end<(n-1) && s.charAt(start-1) == s.charAt(end+1)) {
                start--; end++;
            }
            int sum = end- start + 1;
            if(sum > result) {
                result = sum;
                max = s.substring(start,end+1);
            }
        }
        if(result==1) max += s.charAt(0); //最大回文串为1.
        return max;
    }
}
```

**略优化** 48ms

```java
public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n==0 || n== 1) return s;
        int result = 1;
        int begin = 0;
        String max = "";
        for(int i=0; i<n; i++) {
            int start = i, end =i;
            while((end+1) < n && s.charAt(end) == s.charAt(end+1)) end++;
            while(start>0 && end<(n-1) && s.charAt(start-1) == s.charAt(end+1)) {
                start--; end++;
            }
            int sum = end- start + 1;
            if(sum > result) {
                result = sum;
                begin = start;
            }
        } 
        max = s.substring(begin, begin+result);
        return max;
    }
}
```



### quicker

```java
public class Solution {
    public String longestPalindrome(String s) {
    if(s==null){
        return "";
    }
   char[] arr = s.toCharArray();
	  int max = 0;
	  int maxi = 0;
	  int maxj = 0;
	  
	  for(int i = 0; i< arr.length;){
		  int i1 = getFarestSameElementIndex(arr,i);
		  int dist = getDistance(arr,i,i1);
		  int index1 = i-dist;
		  int index2 = i1 + dist;
		  int l = index2 - index1;
		  if(l>max){
		          max = l;
			  maxi = index1;
			  maxj = index2;
		  }
		  i = i1+1;
	  }
	  
	  return s.substring(maxi, maxj+1);
}

private int getDistance(char[] arr,int index1,int index2){
	int i1 = index1-1;
	int i2 = index2+1;
	int dist = 0;
	while(i1>=0&&i2<arr.length){
		if(arr[i1]==arr[i2]){
			dist++;
		}else{
			break;
		}
		i1--;i2++;
	}
	return dist;
}

private int getFarestSameElementIndex(char[] arr, int index){
	for(int i = index+1;i<arr.length;i++){
		if(arr[i]!=arr[index]){
			return i-1;
		}
	}
	return arr.length-1;
}
}
```

