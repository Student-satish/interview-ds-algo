// problem description
// given array of even length
// task is to divide array into teams of each size 2 with equal sum;
// return -1 if we are unable to divide teams of equal sum
// return sum of products of each team which is called totalchemistry;
// idea store frequency of each number and then use two pointers
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int[] freqCnt = new int[1001];
        int leftMin = 1001, rightMax = 0;
        for(int num : skill) {
            freqCnt[num]++;
            rightMax = Math.max(rightMax,num);
            leftMin = Math.min(leftMin,num);
        }
        int perTeamSkill = leftMin + rightMax;
        long totalChem = leftMin * rightMax;
        freqCnt[leftMin]--;
        freqCnt[rightMax]--;
        while(leftMin <= rightMax) {
            if(freqCnt[leftMin] == 0 && freqCnt[rightMax] == 0) {
                leftMin++;
                rightMax--;
            }else if(freqCnt[leftMin] == 0) {
                leftMin++;
            }else if(freqCnt[rightMax] == 0) {
                rightMax--;
            }else{
                if(perTeamSkill != (leftMin+rightMax)) {
                    return -1;
                }else{
                    totalChem += leftMin * rightMax;
                    freqCnt[leftMin]--;
                    freqCnt[rightMax]--;
                }
            }
        }
        return totalChem;
    }
}
