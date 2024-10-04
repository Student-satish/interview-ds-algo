import java.util.*;
// problem description
// given array of even length
// task is to divide array into teams of each size 2 with equal sum;
// return -1 if we are unable to divide teams of equal sum
// return sum of products of each team which is called totalchemistry;
// idea is sort the array
class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        long totChem = 0 , perTeamSkill = -1;
        for(int i = 0; i < n / 2; i++) {
            if(perTeamSkill == -1) {
                perTeamSkill = skill[i] + skill[n-i-1];
            }else if(perTeamSkill != (skill[i] + skill[n-i-1])) {
                return -1;
            }
            totChem += skill[i] * skill[n-i-1];
        }
        return totChem;
    }
}
