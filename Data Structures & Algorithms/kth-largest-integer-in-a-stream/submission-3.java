class KthLargest {

    private PriorityQueue<Integer> q = new PriorityQueue<>();
    private int k;
    //private int counter;
    //private int max = Integer.MIN_VALUE;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        //this.counter = nums.length - 1;
        //this.nums = nums;
        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]);
        }
        while (q.size() > k) {
            q.poll();
        }
    }
    
    public int add(int val) {
        if (q.size() == 0) {
            q.add(val);
            return val;
        }

        else if (q.size() < k) {
            q.add(val);
            return q.peek();
        }

        else {
            int cur = q.peek();
            if (val < cur) return cur;
            else {
                q.poll();
                q.add(val);
                cur = q.peek();
                return cur;
            }
        }
    }
}
