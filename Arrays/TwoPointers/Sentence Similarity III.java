class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(s2.length > s1.length) {
            String[] temp = s2;
            s2 = s1;
            s1 = temp;
        }
        int n = s1.length , m = s2.length;
        // match s2 prefix with s1 prefix
        int left = 0 , i = 0;
        while(left < m && s1[i].equals(s2[left])) {
            i++;
            left++;
        }
        // match s2 suffix with s1 suffix
        int right = m - 1 , j = n - 1;
        while(right >= 0 && s1[j].equals(s2[right])) {
            right--;
            j--;
        }
        return left > right;
    }
}