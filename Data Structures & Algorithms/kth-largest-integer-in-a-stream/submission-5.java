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
            if (q.size() < k) {
                q.add(nums[i]);
            }
            else {
                if (nums[i] > q.peek()) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
    }
    
    public int add(int val) {
        if (q.size() < k) {
            q.add(val);
            return q.peek();
        }

        else {
            if (val > q.peek()) {
                q.poll();
                q.add(val);
            }
            return q.peek();
        }
    }
}
