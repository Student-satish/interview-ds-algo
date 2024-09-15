import java.util.*;
class Solution {
    public int findTheLongestSubstring(String s) {
        //if i am at ith index i need to check what is the longest substring that can form containing vowels in even count
        // 1 ^ 1 ^ 1 = 1
        // 1 ^ 1 = 0
        // it is prefix xor bitmasking 
        // if we add 5 to 0 it will come 5 again
        // here mask is 00000 we will set a is 0 , e is 1 , i is 2 , o is 3 , u is 4 positions 
        HashMap<Integer,Integer> map = new HashMap<>();
        // initially all vowels have even count 
        int mask = 0 , result = 0;
        map.put(mask,-1);
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'a') {
                mask = mask ^ (1 << 0);
            }else if(ch == 'e') {
                mask = mask ^ (1 << 1);
            }else if(ch == 'i') {
                mask = mask ^ (1 << 2);
            }else if(ch == 'o') {
                mask = mask ^ (1 << 3);
            }else if(ch == 'u') {
                mask = mask ^ (1 << 4);
            }
            if(map.containsKey(mask)) {
                result = Math.max(result,i - map.get(mask));
            }else {
                map.put(mask,i);
            }
        }
        return result;
    }
}