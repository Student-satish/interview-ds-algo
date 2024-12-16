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