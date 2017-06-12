Given a binary tree, return the *level order* traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7

```

return its level order traversal as:

```
[
  [3],
  [9,20],
  [15,7]
]
```



```java
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sublist = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            sublist = new ArrayList<Integer>();
            int n = q.size(); //如果在for循环里直接用q.size()会导致offer后，size增加
            for(int i=0; i<n; i++) {
                TreeNode cur = q.poll();
                sublist.add(cur.val);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right!=null) {
                    q.offer(cur.right);
                }
            }
            if(sublist.size() > 0) list.add(sublist);
        }
        
        return list;
    }
}
```

