class MinStack {

    private LinkedList<Long> list = new LinkedList<>();
    private long min = Integer.MAX_VALUE;

    public MinStack() {
       
    }
    
    public void push(int val) {
        if (list.isEmpty()) {
            min = val;
            list.add((long)0);
        }

        else {
            list.add(val - min);
            if (val < min) {
                min = val;
            }
        }
    }
    
    public void pop() {
        long cur = list.pollLast();
        if (cur < 0) min -= cur;
    }
    
    public int top() {
        long cur = list.peekLast();
        return cur <= 0 ? (int)min : (int)(list.peekLast() + min);
    }
    
    public int getMin() {
        return (int)min;
    }
}
