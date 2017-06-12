Invert a binary tree.

```
     4
   /   \
  2     7
 / \   / \
1   3 6   9
```

to

```
     4
   /   \
  7     2
 / \   / \
9   6 3   1
```

Trivia:

This problem was inspired by 

this original tweet

 by 

Max Howell

:

> Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.



```java
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
}
```

```java
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode tmp = cur.right;
            cur.right = cur.left;
            cur.left = tmp;
            if(cur.left!=null) q.offer(cur.left);
            if(cur.right!=null) q.offer(cur.right);
        }
        return root;
    }
}
```

