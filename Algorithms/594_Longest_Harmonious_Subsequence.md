We define a harmonious array is an array where the difference between its maximum value and its minimum value is **exactly** 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible [subsequences](https://en.wikipedia.org/wiki/Subsequence).

**Example 1:**

```
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].

```

**Note:** The length of the input array will not exceed 20,000.

### my answer

```java
public class Solution {
    public int findLHS(int[] nums) {
    	int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n; i++) {
        	if(map.get(nums[i])==null) {
        		map.put(nums[i],1);
        	}else {
        		map.put(nums[i], map.get(nums[i])+1);
        	}
        }
        
        int max = 0;
        for(int key: map.keySet()) {
        	int sum = Integer.MIN_VALUE;
        	int value = map.get(key);
        	if(map.get(key-1) != null) sum =  map.get(key-1) + value;
        	if(sum > max) max = sum;
        	if(map.get(key+1) != null) sum =  map.get(key+1) + value;
        	if(sum > max) max = sum;
        }
        return max;
    }
}
```

