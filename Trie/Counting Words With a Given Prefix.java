class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;
        public TrieNode() {
            this.count = 0;
            this.children = new TrieNode[26];
        }
    }
    TrieNode root = new TrieNode();
    public void addWord(String str) {
        TrieNode curr = root;
        for(int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i) - 'a';
            if(curr.children[pos] == null) {
                curr.children[pos] = new TrieNode();
            }
            curr = curr.children[pos];
            curr.count++;
        }
    }
    public int getPrefixCount(String pref) {
        TrieNode curr = root;
        for(int i = 0; i < pref.length(); i++) {
            int pos = pref.charAt(i) - 'a';
            if(curr.children[pos] == null) {
                return 0;
            }
            curr = curr.children[pos];
        }
        return curr.count;
    }
    public int prefixCount(String[] words, String pref) {
        int n = words.length;
        for(String str : words) {
            addWord(str);
        }
        return getPrefixCount(pref);
    }
}


class Solution {
    public int prefixCount(String[] words, String pref) {
        int n = words.length , ans = 0;
        for(int i = 0; i < n; i++) {
            if(words[i].startsWith(pref)) {
                ans++;
            }
        }
        return ans;
    }
}
