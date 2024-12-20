import java.util.*;

// BFS
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            List<TreeNode> oddLevelNodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if (level % 2 != 0) {
                    oddLevelNodes.add(curr);
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if (level % 2 != 0) {
                int l = 0, r = oddLevelNodes.size() - 1;
                while (l < r) {
                    int temp = oddLevelNodes.get(l).val;
                    oddLevelNodes.get(l).val = oddLevelNodes.get(r).val;
                    oddLevelNodes.get(r).val = temp;
                    l++;
                    r--;
                }
            }

            level++;
        }

        return root;
    }
}

// DFS

class Solution {
    public void traverseDFS(TreeNode leftChild,TreeNode rightChild,int level) {
        if(leftChild == null || rightChild == null) {
            return;
        }

        if(level % 2 == 0) {
            int temp = leftChild.val;
            leftChild.val = rightChild.val;
            rightChild.val = temp;
        }
        
        traverseDFS(leftChild.left,rightChild.right,level+1);
        traverseDFS(leftChild.right,rightChild.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        traverseDFS(root.left,root.right,0);
        return root;
    }
}
