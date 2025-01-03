// Two pass
class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> map = new HashMap<>();
        int x = 0;
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                x++;
            }else{
                map.put(secret.charAt(i),map.getOrDefault(secret.charAt(i),0)+1);
            }
        }
        int y = 0;
        for(int i = 0; i < secret.length(); i++) {
            char ch1 = secret.charAt(i) , ch2 = guess.charAt(i);
            if(ch1 == ch2) {
                continue;
            }
            if(map.containsKey(ch2)) {
                map.put(ch2,map.get(ch2) - 1);
                if(map.get(ch2) == 0) {
                    map.remove(ch2); 
                }
                y++;
            }
        }
        String ans = x + "A"  + y + "B";
        return ans;
    }
}

// one pass

class Solution {
    public String getHint(String secret, String guess) {
        int[] digitCnt = new int[10];
        int x = 0, y = 0;
        for (int i = 0; i < secret.length(); i++) {
            char ch1 = secret.charAt(i), ch2 = guess.charAt(i);
            if (ch1 == ch2) {
                x++;
            } else {
                if (digitCnt[ch1 - '0'] < 0)
                    y++;
                if (digitCnt[ch2 - '0'] > 0)
                    y++;
                digitCnt[ch1 - '0']++;
                digitCnt[ch2 - '0']--;
            }
        }
        return x + "A" + y + "B";
    }
}
