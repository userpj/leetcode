Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

```java
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode head = arrayToBST(nums,0,nums.length-1);
        return head;
    }
    
    private TreeNode arrayToBST(int[] nums, int start, int end) {
        if(start > end) return null;
        
        int mid = start + (end-start)/2;
        TreeNode midnode = new TreeNode(nums[mid]);
        midnode.left = arrayToBST(nums,start,mid - 1);
        midnode.right = arrayToBST(nums,mid+1,end);
        
        return midnode;
    }
}
```

