class Solution {
    class TrieNode {
        HashMap<Integer,TrieNode> children = new HashMap<>();
        int count;
        public TrieNode() {
            this.count = 0;
        }
    }
    TrieNode root = new TrieNode();
    public long countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        long ans = 0;
        for(int i = 0; i < n; i++) {
            TrieNode curr = root;
            String str = words[i];
            int len = str.length();
            for(int j = 0; j < len; j++) {
                // group first and last char and get hash(unique value)
                int hash = str.charAt(j) * 128 + str.charAt(len-j-1);
                if(curr.children.get(hash) == null) {
                    curr.children.put(hash,new TrieNode());
                }
                curr = curr.children.get(hash);
                ans += curr.count;
            }
            curr.count++;
        }
        return ans;
    }
}
