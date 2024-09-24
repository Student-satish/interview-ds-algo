class Solution {
    class TrieNode {
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[10];
        }
    }

    TrieNode root = new TrieNode();

    public void insertNum(String num) {
        TrieNode curr = root;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (curr.children[digit] == null) {
                curr.children[digit] = new TrieNode();
            }
            curr = curr.children[digit];
        }
    }

    public int getPrefixLen(String num) {
        TrieNode curr = root;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            if (curr.children[digit] == null)
                return i;
            curr = curr.children[digit];
        }
        return num.length();
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length, m = arr2.length;
        for (int i = 0; i < n; i++) {
            insertNum(String.valueOf(arr1[i]));
        }
        int maxLenOfPrefix = 0;
        for (int i = 0; i < m; i++) {
            maxLenOfPrefix = Math.max(maxLenOfPrefix, getPrefixLen(String.valueOf(arr2[i])));
        }
        return maxLenOfPrefix;

    }
}