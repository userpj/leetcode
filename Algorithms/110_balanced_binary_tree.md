Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

```java
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return dfsHeight(root) != -1; 
    }
    
    private int dfsHeight(TreeNode root) {
        if(root==null) return 0;
        int l = dfsHeight(root.left);
        int r = dfsHeight(root.right);
        if(l == -1 || r == -1 || Math.abs(l-r) > 1) return -1;
        return Math.max(l,r) + 1;
    }
}
```

