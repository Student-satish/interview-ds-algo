class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n+1];
        for(int[] shift : shifts) {
            if(shift[2] == 1) {
                diffArray[shift[0]]++;
                diffArray[shift[1]+1]--;
            }else{
                diffArray[shift[0]]--;
                diffArray[shift[1]+1]++;
            }
        }
        int numberOfShifts = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            numberOfShifts += diffArray[i] % 26;
            if (numberOfShifts < 0) numberOfShifts += 26; // To handle negative shifts
            char newChar = (char) ((s.charAt(i) - 'a' + numberOfShifts) % 26 + 'a');
            ans.append(newChar);
        }
        return ans.toString();
    }
}
