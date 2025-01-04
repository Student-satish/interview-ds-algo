class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            friends.add(i);
        int removableFrnd = k - 1;
        while (friends.size() > 1) {
            friends.remove(removableFrnd);
            removableFrnd = (removableFrnd + k - 1) % friends.size();
        }
        return friends.get(0);
    }
}

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) q.offer(i);
        while(q.size() > 1) {
            for(int i = 1; i < k; i++) {
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}


class Solution {
    public int solve(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (solve(n - 1, k) + k) % n;
    }

    public int findTheWinner(int n, int k) {
        return solve(n, k) + 1;

    }
}
