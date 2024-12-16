import java.util.*;

// using pq
class Solution {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[a], nums[b]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(nums[b], nums[a]));
        int n = nums.length, left = 0, right = 0;
        long ans = 0;
        while (right < n) {
            minHeap.offer(right);
            maxHeap.offer(right);
            while (left < right && nums[maxHeap.peek()] - nums[minHeap.peek()] > 2) {
                left = Math.min(maxHeap.peek(), minHeap.peek()) + 1;
                while (!maxHeap.isEmpty() && maxHeap.peek() < left) {
                    maxHeap.poll();
                }
                while (!minHeap.isEmpty() && minHeap.peek() < left) {
                    minHeap.poll();
                }
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}

// using treemap
class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int left = 0 , right = 0;
        long ans = 0;
        while(right < n) {
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.lastEntry().getKey() - map.firstEntry().getKey() > 2) {
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}

// deque approach 
class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> maxDq = new ArrayDeque<>();
        Deque<Integer> minDq = new ArrayDeque<>();
        int left = 0 , right = 0 , n = nums.length;
        long ans = 0;
        while(right < n) {
            while(!minDq.isEmpty() && nums[right] <= nums[minDq.peekLast()]) {
                minDq.pollLast();
            }
            while(!maxDq.isEmpty() && nums[right] >= nums[maxDq.peekLast()]) {
                maxDq.pollLast();
            }
            minDq.offerLast(right);
            maxDq.offerLast(right);
            while(!minDq.isEmpty() && !maxDq.isEmpty() && nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > 2) {
                int jump = Math.min(maxDq.peekFirst(),minDq.peekFirst());
                left = jump + 1;
                while(!minDq.isEmpty() && minDq.peekFirst() < left) {
                    minDq.pollFirst();
                }
                while(!maxDq.isEmpty() && maxDq.peekFirst() < left) {
                    maxDq.pollFirst();
                }
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}



// O(n) solution two pointer

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int left = 0 , right = 0 , min = Integer.MAX_VALUE , max = 0;
        long ans = 0;
        while(right < n) {
            max = Math.max(nums[right],max);
            min = Math.min(nums[right],min);
            if(max - min > 2) {
                left = right;
                max = nums[left];
                min = nums[left];
                while(Math.abs(nums[right] - nums[left-1]) <= 2) {
                    left--;
                    max = Math.max(max,nums[left]);
                    min = Math.min(min,nums[left]);
                }
            }
            ans += right - left + 1; 
            right++;
        }
        return ans;
    }
}
