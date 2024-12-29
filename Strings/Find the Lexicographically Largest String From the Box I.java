class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) {
            return word;
        }
        String res = "";
        int n = word.length() , m = n - numFriends + 1;
        for(int i = 0; i < n; i++) {
            if(res.compareTo(word.substring(i,Math.min(n,i+m))) < 0) {
                res = word.substring(i,Math.min(n,i+m));
            }
        }
        return res;

        // lexicographically smaller means
        // -> smallest character
        // -> smallest length

        // lexicographically larger means
        // -> larger character
        // -> larger length
    }
}