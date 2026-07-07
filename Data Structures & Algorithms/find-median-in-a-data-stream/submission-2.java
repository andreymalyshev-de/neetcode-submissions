class MedianFinder {
    private PriorityQueue<Integer> q1;
    private PriorityQueue<Integer> q2;

    public MedianFinder() {
        q1 = new PriorityQueue<>(Comparator.reverseOrder());
        q2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        q1.offer(num);
        q2.offer(q1.poll());

        if (q2.size() > q1.size()) {
            q1.offer(q2.poll());
        }

        //System.out.println("h1: " + (q1.isEmpty() ? null : q1.peek()) + ", h2: " + (q2.isEmpty() ? null : q2.peek()));
    }
    
    public double findMedian() {
        if (q1.size() == q2.size()) return (double)(q1.peek() + q2.peek()) / 2;
        if (q1.size() > q2.size()) return q1.peek();
        else return q2.peek();
    }
}
