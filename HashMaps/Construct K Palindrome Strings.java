class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() == k) {
            return true;
        }
        if(s.length() < k) {
            return false;
        }
        int oddCnt = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int freq : map.values()) {
            oddCnt += freq % 2;
        }
        return oddCnt <= k;
    }
}
