Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



### my answer

```java
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	if(p==null && q==null) return true; //add
    	if((p==null && q!=null) || (p!=null && q==null)) return false; //add
        if(p.val!=q.val) return false;
        //if((p.left==null && q.left!=null) || (p.left!=null && q.left==null)) return false;
        //if((p.right==null && q.right!=null) || (p.right!=null && q.right==null)) return false;
        //if(p.left!= null &q.left!=null && !isSameTree(p.left,q.left)) return false;
        //if(p.right!= null &&q.right!=null && !isSameTree(p.right,q.right)) return false;
        if(!isSameTree(p.left,q.left)) return false;
        if(!isSameTree(p.right,q.right)) return false;
        return true;
    }
}
```



### better answer

```java
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
```

```java
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;
```

```java
if (p == null || q == null) return p == q;
```