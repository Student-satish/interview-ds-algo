class Solution {
    public int getMinOps(int[] original) {
        int[] target = original.clone();
        Arrays.sort(target);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < original.length; i++) {
            map.put(original[i],i);
        }
        int ops = 0;
        for(int i = 0; i < original.length; i++) {
            if(target[i] != original[i]) {
                int currPos = map.get(target[i]);
                map.put(original[i],currPos);
                original[currPos] = original[i];
                ops++;
            }
        }
        return ops;
    }
    public int minimumOperations(TreeNode root) {
        int totalOps = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            int[] levelVal = new int[n];
            for(int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
                levelVal[i] = curr.val;
            }
            totalOps += getMinOps(levelVal);
        }
        return totalOps;
    }
}