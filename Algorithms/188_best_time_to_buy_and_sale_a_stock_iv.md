Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete at most **k** transactions.

**Note:**
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

### my answer

```java
public class Solution {
	   public int maxProfit(int k, int[] prices) {
	    	if(prices.length==0 || prices==null) return 0;
	        int n = prices.length;
	    	int countk = 0;
	    	int resultk = 0;
         //不限次的最大收益，如果k大于此次数，说明最大收益即resultk.
	    	for(int i = 0; i < n-1; i++) {
	    		if(prices[i+1]-prices[i] > 0) {
	    			countk += 1;
	    			resultk += prices[i+1] - prices[i];
	    		}
	    	}
	    	if(countk <= k) return resultk;
	        int[] local = new int[k+1];
	        int[] global = new int[k+1];
	        for(int i = 0; i< n-1; i++) {
	        	int diff = prices[i+1] - prices[i];
	        	for(int j = k; j >= 1; j--) {
                  /*local[j]:最多k次交易的局部最优解。在第i天出手。
                  global[j]:最多k次交易的全局最优解。
                  */
	        		local[j] = Math.max(global[j-1] + Math.max(diff, 0), local[j]+diff);
	        		global[j] = Math.max(global[j], local[j]);
	        	}
	        }
	    
	    return global[k];
	}
}
```

