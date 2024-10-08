class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        // here for one swap two pairs are becoming balance 
        // if we want four pairs to balance we just require 2 swapps 
        // for odd case just add one swap more
        // ]][[ after swapping 0 and 3 positions in this string it will become like this [][] so we have taken just one swap to balance two pairs
        // remove balanced substrings
        // after removing input always looks like  in this format ]]][[[
        // count unbalanced openbrackets or closedbrackets return openBrac / 2 for even and  for odd case (openBrac + 1) / 2 bcz we are taking extra swap to balance that pair
        int openBrac = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '[') {
                openBrac++;
            }else{
                // remove all the balanced substrings
                if(openBrac > 0) {
                    openBrac--;
                }
            }
        }
        // odd case just we have to do one more swap
        return (openBrac + 1) / 2;
    }
}
