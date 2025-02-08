class NumberContainers {
    HashMap<Integer, Integer> idx = new HashMap<>();
    HashMap<Integer, TreeSet<Integer>> numToIndices;

    public NumberContainers() {
        this.numToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (idx.containsKey(index)) {
            int prevNum = idx.get(index);
            numToIndices.get(prevNum).remove(index);
            if (numToIndices.get(prevNum).size() == 0)
                numToIndices.remove(prevNum);
        }
        if (!numToIndices.containsKey(number)) {
            numToIndices.put(number, new TreeSet<>());
        }
        numToIndices.get(number).add(index);

        idx.put(index, number);

    }

    public int find(int number) {
        if (numToIndices.containsKey(number)) {
            return numToIndices.get(number).first();
        }

        return -1;

    }
}