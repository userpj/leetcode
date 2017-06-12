Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

```java
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int maxleft = maxDepth(root.left) + 1;
        int maxright = maxDepth(root.right) +1;
        return Math.max(maxleft,maxright);
    }
}
```

### BFS

```java
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            count++;
        }
        return count;
    }
}
```

### DFS

```java
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int tmp = value.pop();
            max = Math.max(tmp,max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(tmp+1);
            }
            if(node.right!=null) {
                stack.push(node.right);
                value.push(tmp+1);
            }
        }
        return max;
    }
}
```

