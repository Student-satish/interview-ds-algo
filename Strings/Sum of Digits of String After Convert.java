class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        // step - 1 : convert string to number format;
        String num = "";
        for(int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a' + 1;
            num += x;
        }
        // step - 2 : sum all digits in num k times
        int sum = 0;
        for(int i = 1; i <= k; i++) {
            sum = 0;
            for(int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }
            num = "";
            num += sum;
        }
        return sum;
    }
}