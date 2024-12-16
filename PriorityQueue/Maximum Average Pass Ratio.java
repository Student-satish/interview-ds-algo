import java.util.*;
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                (b[0] + 1) / (b[1] + 1) - b[0] / b[1],
                (a[0] + 1) / (a[1] + 1) - a[0] / a[1]
            )
        );
        
        for (int[] clazz : classes) { 
            pq.offer(new double[]{clazz[0], clazz[1]});
        }
        
        for (int i = 0; i < extraStudents; i++) {
            double[] clazz = pq.poll(); 
            pq.offer(new double[]{clazz[0] + 1, clazz[1] + 1});
        }
        
        double average = 0.0;
        while (!pq.isEmpty()) {
            double[] clazz = pq.poll(); 
            average += clazz[0] / clazz[1];
        }
        
        return average / classes.length;
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