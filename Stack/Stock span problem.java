class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Stack<int[]> s = new Stack<>();
        s.push(new int[]{arr[0],1});
        res.add(1);
        for(int i = 1; i < n; i++) {
            int span = 1;
            while(!s.isEmpty() && arr[i] >= s.peek()[0]) {
                span += s.peek()[1];
                s.pop();
            }
            s.push(new int[]{arr[i],span});
            res.add(span);
        }
        return res;
    }
}