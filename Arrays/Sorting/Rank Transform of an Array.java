class Solution {
    class Pair {
        int num;
        int idx;

        public Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        // create pair type object array
        Pair[] sortedOrder = new Pair[n];
        for (int i = 0; i < n; i++) {
            sortedOrder[i] = new Pair(arr[i], i);
        }
        // sort the array in ascending order
        Arrays.sort(sortedOrder, (a, b) -> Integer.compare(a.num, b.num));
        int[] res = new int[n];
        int rank = 0, prev = -1;
        for (Pair p : sortedOrder) {
            // change the rank if the element is greater than prev element
            if (rank == 0 || prev != p.num) {
                rank++;
                prev = p.num;
            }
            res[p.idx] = rank;
        }
        return res;
    }
}
