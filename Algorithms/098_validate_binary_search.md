Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys **less than** the node's key.
- The right subtree of a node contains only nodes with keys **greater than** the node's key.
- Both the left and right subtrees must also be binary search trees.

**Example 1:**

```
    2
   / \
  1   3

```

Binary tree 

```
[2,1,3]
```

, return true.

**Example 2:**

```
    1
   / \
  2   3

```

Binary tree 

```
[1,2,3]
```

, return false.



平衡二叉树，中序遍历返回从小到大。

### Wrong answer

Because Java is "pass by value". Let's see that you pass an object like TreeNode. What you've actually passed to Java method is a copy reference of original reference. So whatever you modified on inside method is the copy reference. The original reference remains unchanged. In this case(code written in Java and pass reference variable), you modified copy reference of prev to node, but the original prev is still null. That is why it returns true for [1,1]. I would use class variable for prev. 

```java
public class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode pre = null;
        return isvalid(root, pre);
    }
    
    private boolean isvalid(TreeNode root, TreeNode pre) {
        if(root==null) return true;
        if(!isvalid(root.left,pre)) return false;
        if(pre!=null && pre.val >= root.val) return false;
        pre = root;
        return isvalid(root.right,pre);
    }
}
```

### Accepted

```java
public class Solution {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(!isValidBST(root.left)) return false;
        if(pre!=null && pre.val >= root.val) return false;
        pre = root;
        return isValidBST(root.right);
    }
}
```



```java
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre!= null && pre.val >= cur.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
```

还可以用链表保存遍历结果，看是否满足增序。