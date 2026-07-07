class MedianFinder {
    private PriorityQueue<Integer> q1;
    private PriorityQueue<Integer> q2;

    public MedianFinder() {
        q1 = new PriorityQueue<>(Comparator.reverseOrder());
        q2 = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (q1.isEmpty() && q2.isEmpty()) q1.add(num);

        else {
            if (q1.size() > q2.size()) {
                if (num >= q1.peek()) q2.add(num);
                else {
                    q2.add(q1.poll());
                    q1.add(num);
                }
            }
            else if (q2.size() > q1.size()) {
                if (num <= q2.peek()) q1.add(num);
                else {
                    q1.add(q2.poll());
                    q2.add(num);
                }
            }
            else {
                if (num <= q1.peek()) q1.add(num);
                else q2.add(num);
            }
        }

        System.out.println("h1: " + (q1.isEmpty() ? null : q1.peek()) + ", h2: " + (q2.isEmpty() ? null : q2.peek()));
    }
    
    public double findMedian() {
        if (q1.size() == q2.size()) return (double)(q1.peek() + q2.peek()) / 2;
        if (q1.size() > q2.size()) return q1.peek();
        else return q2.peek();
    }
}
