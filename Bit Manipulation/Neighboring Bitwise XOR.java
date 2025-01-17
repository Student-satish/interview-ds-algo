class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        List<Integer> original = new ArrayList<>();
        original.add(0);
        for(int i = 0; i < n - 1; i++) {
            original.add(original.get(i)^derived[i]);
        }
        return (derived[n-1] == (original.get(n-1) ^ original.get(0)))? true : false;
    }
}


class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for(int num : derived) {
            xor ^= num;
        }
        return xor == 0 ? true : false;
    }
}