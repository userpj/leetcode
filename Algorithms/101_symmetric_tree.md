Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3

```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3

```

**Note:**
Bonus points if you could solve it both recursively and iteratively.

### recursive

```java
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return symmetric(root.left, root.right);
    }
    private boolean symmetric(TreeNode left,TreeNode right) {
        if(left==null && right==null) return true;
        if(left != null && right != null && left.val== right.val) return symmetric(left.left, right.right) && symmetric(left.right,right.left);
        return false;
    }
}
```

### interative

```java
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size() > 0) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left==null && right == null) continue;
            if(left==null || right == null) return false;
            if(left.val != right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
```

