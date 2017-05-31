Say you have an array for which the *i*th element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete at most *two* transactions.

### my answer

```java
public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices == null || prices.length==0) return 0;
    	int minleft = prices[0];
    	int maxleft = 0;
    	int[] leftprofit= new int[prices.length];
      //记录从左往右，一次交易每一点的最大值。
    	for(int i = 0; i < prices.length; i++) {
    		if(prices[i] > minleft) maxleft = Math.max(maxleft, prices[i]-minleft);
    		if(prices[i] < minleft) minleft = prices[i];
    		leftprofit[i] = maxleft;
    	}
    	
    	int minright = prices[prices.length-1];
    	int maxright = 0;
    	int maxresult = 0;
    	for(int i = prices.length-1; i >= 0; i--) {
    		if(prices[i] < minright) {
    			maxright = Math.max(maxright, minright - prices[i]);
    			maxresult = Math.max(maxresult, maxright + leftprofit[i]);
    		}
    		if(prices[i] > minright) minright = prices[i];
    	}
    	return maxresult;
    }
	
```

