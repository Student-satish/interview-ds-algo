import java.util.*;
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
