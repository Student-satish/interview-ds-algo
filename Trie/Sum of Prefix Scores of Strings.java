class Solution {
    class Trie {
        Trie[] children;
        int cnt;

        public Trie() {
            children = new Trie[26];
            this.cnt = 0;
        }
    }

    Trie root = new Trie();

    public void insertPrefix(String word) {
        Trie curr = root;
        for (int i = 0; i < word.length(); i++) {
            int charNum = word.charAt(i) - 'a';
            if (curr.children[charNum] == null) {
                curr.children[charNum] = new Trie();
            }
            curr = curr.children[charNum];
            curr.cnt = curr.cnt + 1;
        }
    }

    public int getPrefixScore(String prefix) {
        int n = prefix.length(), score = 0;
        Trie curr = root;
        for (int i = 0; i < n; i++) {
            int charNum = prefix.charAt(i) - 'a';
            curr = curr.children[charNum];
            score += curr.cnt;
        }
        return score;
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            insertPrefix(words[i]);
        }
        for (int i = 0; i < n; i++) {
            score[i] = getPrefixScore(words[i]);
        }
        return score;
    }
}
