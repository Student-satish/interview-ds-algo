import java.util.*;
// lazy propagation method
class CustomStack {
    int[] arr;
    int[] kArray;
    int maxLimit;
    int i;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.kArray = new int[maxSize];
        this.maxLimit = maxSize;
        this.i = 0;
    }

    public void push(int x) {
        if (i >= maxLimit)
            return;
        arr[i++] = x;
    }

    public int pop() {
        if (i <= 0)
            return -1;
        // propagate the inc val from current index to prev index
        if (i > 1) {
            kArray[i - 2] += kArray[i - 1];
        }
        int ans = arr[i - 1] + kArray[i - 1];
        kArray[i - 1] = 0;
        i--;
        return ans;
    }

    public void increment(int k, int val) {
        int limit = Math.min(k, i);
        if (limit > 0) {
            kArray[limit - 1] += val;
        }
    }
}
// brute force
class CustomStack {
    List<Integer> stack;
    int maxLimit;

    public CustomStack(int maxSize) {
        stack = new ArrayList<>();
        this.maxLimit = maxSize;
    }

    public void push(int x) {
        if (stack.size() >= maxLimit)
            return;
        stack.add(x);
    }

    public int pop() {
        if (stack.size() < 1)
            return -1;
        return stack.remove(stack.size()-1);
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(stack.size(), k); i++) {
            stack.set(i, stack.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */