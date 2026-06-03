class MinStack {

    private LinkedList<Integer> list = new LinkedList<>();
    private int min = Integer.MAX_VALUE;
    private List<Integer> mins = new ArrayList<>();

    public MinStack() {
       
    }
    
    public void push(int val) {
        list.add(val);
        if (val < min) min = val;
        mins.add(min);
    }
    
    public void pop() {
        //System.out.println(mins);
        list.removeLast();
        mins.remove(mins.size() - 1);
        if (mins.size() > 0) {
            min = mins.get(mins.size() - 1);
        }
        else {
            min = Integer.MAX_VALUE;
        }
        System.out.println(mins);
    }
    
    public int top() {
        return list.peekLast();
    }
    
    public int getMin() {
        return min;
    }
}
