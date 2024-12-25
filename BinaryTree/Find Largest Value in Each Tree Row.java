import java.util.*;
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            int currLevelMax = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                currLevelMax = Math.max(currLevelMax,temp.val);
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
            }
            ans.add(currLevelMax);
        }
        return ans;
    }
}
