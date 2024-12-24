class Solution {
    public int check(String s, char startChar) {
        int ops = 0;
        for (int i = 0; i < s.length(); i++) {
            if (startChar != s.charAt(i)) {
                ops++;
            }
            startChar = startChar == '0' ? '1' : '0';
        }
        return ops;
    }

    public int totalCuts(String s, int mid) {
        if (mid == 1) {
            return Math.min(check(s, '0'), check(s, '1'));
        }
        char lastChar = '*';
        int count = 0, ops = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == lastChar) {
                count++;
            } else {
                ops += count / (mid + 1);
                count = 1;
                lastChar = s.charAt(i);
            }
        }
        ops += count / (mid + 1);
        return ops;
    }

    public int minLength(String s, int numOps) {
        int n = s.length();
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int currOps = totalCuts(s, mid);
            if (currOps > numOps) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
