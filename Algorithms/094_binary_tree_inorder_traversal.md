Given a binary tree, return the *inorder* traversal of its nodes' values.

For example:
Given binary tree `[1,null,2,3]`,

```
   1
    \
     2
    /
   3

```

return `[1,3,2]`.

**Note:** Recursive solution is trivial, could you do it iteratively?



中序遍历。左根右。



### recursive

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        traverse(root,res);
        return res;
    }
    
    public void traverse(TreeNode root,List<Integer> res)
    {
        if(root==null)return;
        traverse(root.left,res);
        res.add(root.val);
        traverse(root.right,res);
        
    }
}
```



### interative

```java
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right; //当curl.right == null，跳过上面的while。
        }
        return list;
    }
}
```



最后我们介绍一种比较复杂的方法，就是如果用常量空间来中序遍历一颗二叉树。这种方法叫 Morris Traversal。想用O(1)空间进行遍历，因为不能用栈作为辅助空间来保存付节点的信息，重点在于当访问到子节点的时候如何重新回到父节点（当然这里是指没有父节点指针，如果有其实就比较好办，一直找遍历的后驱结点即可）。Morris遍历方法用了线索二叉树，这个方法不需要为每个节点额外分配指针指向其前驱和后继结点，而是利用叶子节点中的右空指针指向中序遍历下的后继节点就可以了。
算法具体分情况如下：

1. 如果当前结点的左孩子为空，则输出当前结点并将其当前节点赋值为右孩子。
2. 如果当前节点的左孩子不为空，则寻找当前节点在中序遍历下的前驱节点（也就是当前结点左子树的最右孩子）。接下来分两种情况：
   a) 如果前驱节点的右孩子为空，将它的右孩子设置为当前节点（做线索使得稍后可以重新返回父结点）。然后将当前节点更新为当前节点的左孩子。
    b) 如果前驱节点的右孩子为当前节点，表明左子树已经访问完，可以访问当前节点。将它的右孩子重新设为空（恢复树的结构）。输出当前节点。当前节点更新为当前节点的右孩子

```java
public ArrayList<Integer> inorderTraversal(TreeNode root) {  
    ArrayList<Integer> res = new ArrayList<Integer>();  
    TreeNode cur = root;  
    TreeNode pre = null;  
    while(cur != null)  
    {  
        if(cur.left == null)  
        {  
            res.add(cur.val);  
            cur = cur.right;  
        }  
        else  
        {  
            pre = cur.left;  
            while(pre.right!=null && pre.right!=cur)  
                pre = pre.right;  
            if(pre.right==null)  
            {  
                pre.right = cur;  
                cur = cur.left;  
            }  
            else  
            {  
                pre.right = null;  
                res.add(cur.val);  
                cur = cur.right;  
            }  
        }  
    }  
    return res;  
}  
```

