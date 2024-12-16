import java.util.*;
class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for(int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{nums[i],i});
        }
        for(int i = 0; i < k; i++) {
            int[] info = pq.poll();
            pq.offer(new int[]{info[0]*multiplier,info[1]});
        }
        int[] ans = new int[nums.length];
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            ans[info[1]] = info[0];
        }
        return ans;
    }
}

// comparable interface

import java.util.PriorityQueue;

class Solution {

    // Custom class representing a class
    class Class implements Comparable<Class> {
        double passed;  // Number of students who passed
        double total;   // Total number of students

        Class(double passed, double total) {
            this.passed = passed;
            this.total = total;
        }

        // Calculate the potential gain in pass ratio if one extra student is added
        private double gain() {
            return ((passed + 1) / (total + 1)) - (passed / total);
        }

        // Define comparison logic based on the gain
        @Override
        public int compareTo(Class other) {
            return Double.compare(other.gain(), this.gain()); // Max-Heap
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Priority queue to store and sort classes based on their gain
        PriorityQueue<Class> pq = new PriorityQueue<>();

        // Add all classes to the priority queue
        for (int[] clazz : classes) {
            pq.offer(new Class(clazz[0], clazz[1]));
        }

        // Allocate extra students
        for (int i = 0; i < extraStudents; i++) {
            Class clazz = pq.poll(); // Poll the class with the highest gain
            pq.offer(new Class(clazz.passed + 1, clazz.total + 1)); // Add one student
        }

        // Calculate the final average ratio
        double average = 0.0;
        while (!pq.isEmpty()) {
            Class clazz = pq.poll();
            average += clazz.passed / clazz.total;
        }

        return average / classes.length;
    }
}

