class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        // step - 1 : find the sum of the chalk array
        long totalChalks = 0;
        for(int num : chalk) totalChalks += num;
        // step - 2 : find the remaining chalks after distributing exactly x times to all students
        k %= totalChalks;
        // step - 3 : find the student who has less number of chalks 
        for(int i = 0; i < n; i++) {
            if(chalk[i] > k) return i;
            k -= chalk[i];
        }
        return -1;
        
    }
}
