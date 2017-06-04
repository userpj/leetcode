Given *n* non-negative integers *a1*, *a2*, ..., *an*, where each represents a point at coordinate (*i*, *ai*). *n* vertical lines are drawn such that the two endpoints of line *i* is at (*i*, *ai*) and (*i*, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and *n* is at least 2.

**题意**

求min(a[i], a[j]) * (j-i)的最大值。(ps:i<j)

```java
public class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        for(int i = 0; i <n;) {
        	max = Math.max(max, (n-i-1)*Math.min(height[n-1],height[i]));
        	if(height[i]>height[n-1]) n--;
        	else i++;
        }
        return max;
    }
}
```

