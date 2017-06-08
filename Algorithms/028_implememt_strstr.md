Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

返回串needle在haystack中第一次出现的序号，否则返回-1；

**TLE**

```java
public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        //if(len1==0 && len2 == 0) return 0;
        if(len2 == 0) return 0; //add2
        if(len1 < len2) return -1; //add
        //if(len1==0 || len2 == 0) return -1;
        for(int i = 0; i<len1; i++) {
            int point = i;
            //for(int j=0; j<len2; j++) {
            
            /*
            for(int j=0; j<len2;j++) { //去掉j++会死循环。
                if(point >= len1) return -1; //add3
                if(haystack.charAt(point) == needle.charAt(j)) {
                    point++;
                    //if(point >= len1) return -1; //add，防止s1溢出
                    j++;
                }
                */
            
            int j = 0;
            while(point < len1 && j < len2 && haystack.charAt(point) == needle.charAt(j)) {
            	point++;
            	j++;
            }
            
                //if(j==len2) return i - len2 +1;
                //if(j==len2) return point - len2 + 1;
            if(j==len2) return point - len2;//因为最后point++，故不需要+1
        }
        return -1;
    }
}
```



稍微优化

```java
public class Solution {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if(len2 == 0) return 0; 
        if(len1 < len2) return -1; 

        for(int i = 0; i<len1-len2+1; i++) { //需要+1
            int j = 0;
            while(j < len2 && haystack.charAt(i+j) == needle.charAt(j)) {
            	j++;
            }
            
            if(j==len2) return i;
        }
        return -1;
    }
}
```

