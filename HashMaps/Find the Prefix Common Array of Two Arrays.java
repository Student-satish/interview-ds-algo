class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            int cmnCnt = 0;
            for(int j = 0; j <= i; j++) {
                for(int k = 0; k <= i; k++) {
                    if(A[j] == B[k]) {
                        cmnCnt++;
                        break;
                    }
                }
            }
            ans[i] = cmnCnt;
        }
        return ans;
    }
}

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freq = new int[n+1];
        int[] ans = new int[n];
        int cmnCnt = 0;
        for(int i = 0; i < n; i++) {
            freq[A[i]]++;
            if(freq[A[i]] == 2) cmnCnt++;
            freq[B[i]]++;
            if(freq[B[i]] == 2) cmnCnt++;
            ans[i] = cmnCnt;
        }
        return ans;
    }
}


class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        HashSet<Integer> st = new HashSet<>();
        int[] ans = new int[n];
        int common = 0;
        for (int i = 0; i < A.length; i++) {
            if (st.contains(A[i])) {
                common++;
            } else {
                st.add(A[i]);
            }
            if (st.contains(B[i])) {
                common++;
            } else {
                st.add(B[i]);
            }
            ans[i] = common;
        }
        return ans;
    }
}
