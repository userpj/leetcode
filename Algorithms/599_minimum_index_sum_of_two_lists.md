Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings.

You need to help them find out their **common interest** with the **least list index sum**. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.

**Example 1:**

```
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

```

**Example 2:**

```
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

```

**Note:**

1. The length of both lists will be in the range of [1, 1000].
2. The length of strings in both lists will be in the range of [1, 30].
3. The index is starting from 0 to the list length minus 1.
4. No duplicates in both lists.



### my answer

```java
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int l1 = list1.length;
        int l2 = list2.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < l1; i++) map.put(list1[i], i);
        
        int max = Integer.MAX_VALUE;
        ArrayList<String> result= new ArrayList<String>();
        for(int j=0; j< l2; j++ ) {
        	if(map.get(list2[j])==null) continue;
        	int i = map.get(list2[j]);
        	if(i+j > max) continue;
        	if(i+j < max) result = new ArrayList<>();
        	result.add(list1[i]);
        	max = i + j;
        }
        	
        return result.toArray(new String[result.size()]);
    }
}
```

