class Solution {
    public int minAddToMakeValid(String s) {
      // test cases "))((" , "))(()))("
        int n = s.length();
        int openBrac = 0 , closedBrac = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '(') {
                openBrac++;
            }else{
                if(openBrac > 0) {
                    openBrac--;
                }else{
                    closedBrac++;
                }
            }
        }
        return openBrac + closedBrac;
    }
}
