//Brute Force
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (true) {
                int smallValue = nums[i];
                int idx = -1;
                for (int j = i + 1; j < n; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= limit) {
                        if (nums[j] < smallValue) {
                            smallValue = nums[j];
                            idx = j;
                        }
                    }
                }
                if (idx == -1)
                    break;
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }
        return nums;
    }
}

// optmal solution

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums,n);
        Arrays.sort(copy);
        HashMap<Integer,Queue<Integer>> groups = new HashMap<>();
        HashMap<Integer,Integer> numToGroupnum = new HashMap<>();
        int groupNum = 0;
        groups.put(groupNum,new LinkedList<>());
        groups.get(groupNum).offer(copy[0]);
        numToGroupnum.put(copy[0],groupNum);
        for(int i = 1; i < n; i++) {
            if(Math.abs(copy[i]-copy[i-1]) > limit) {
                groupNum++;
                groups.put(groupNum,new LinkedList<>());
            }
            groups.get(groupNum).offer(copy[i]);
            numToGroupnum.put(copy[i],groupNum);
        }

        for(int i = 0; i < n; i++) {
            int group = numToGroupnum.get(nums[i]);
            nums[i] = groups.get(group).poll();
        }

        return nums;
        
    }
}